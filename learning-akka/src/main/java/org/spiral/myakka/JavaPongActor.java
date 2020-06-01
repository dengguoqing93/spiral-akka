package org.spiral.myakka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;

/**
 * 接受字符串ping并返回字符串pong
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class JavaPongActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("Ping", s -> sender()
                .tell("Pong", ActorRef.noSender())).matchAny(x -> sender()
                .tell(new Status.Failure(new Exception("unkown message")), self())).build();
    }
}
