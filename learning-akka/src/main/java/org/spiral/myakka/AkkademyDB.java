package org.spiral.myakka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.spiral.myakka.message.GetRequest;
import org.spiral.myakka.message.KeyNotFoundException;
import org.spiral.myakka.message.SetRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Actor收到消息后的相应
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class AkkademyDB extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);

    protected final Map<String, Object> map = new HashMap<String, Object>();


    @Override
    public Receive createReceive() {
        return receiveBuilder().match(SetRequest.class, message -> {
            sender().tell(message, ActorRef.noSender());
            log.info("Received Set request: {}", message);
            map.put(message.getKey(), message.getValue());
            sender().tell(new Status.Success(message.getKey()), self());
        }).match(GetRequest.class, message -> {
            log.info("Received Get request:{}", message);
            Object value = map.get(message.getKey());
            Object response = Objects.nonNull(value) ? value :
                    new Status.Failure(new KeyNotFoundException(message.getKey()));
            sender().tell(response, self());
        }).matchAny(o -> sender().tell(new Status.Failure(new ClassNotFoundException()), self()))
                .build();

    }
}
