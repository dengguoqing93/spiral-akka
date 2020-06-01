package org.spiral.myakka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.spiral.myakka.message.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Actor收到消息后的相应
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class AkkademySenderDB extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);

    protected final Map<String, Object> map = new HashMap<>();


    @Override
    public Receive createReceive() {
        return receiveBuilder().match(SetRequest.class, message -> {
            sender().tell(message, ActorRef.noSender());
            log.info("Received Set request: {}", message);
            map.put(message.getKey(), message.getValue());
        }).matchAny(o -> log.info("received unknown message: {}", o)).build();

    }
}
