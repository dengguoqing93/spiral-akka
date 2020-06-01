package org.spiral.myakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.Test;
import scala.concurrent.Future;

import java.util.concurrent.*;

import static akka.pattern.Patterns.ask;
import static org.junit.Assert.assertEquals;
import static scala.compat.java8.FutureConverters.toJava;

/**
 * ${DESCRIPTION}
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class JavaPongActorTest {
    ActorSystem system = ActorSystem.create();

    ActorRef actorRef = system.actorOf(Props.create(JavaPongActor.class));

    @Test
    public void createReceive() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> jFuture = askPong("Ping");
        assertEquals(jFuture.get(1000, TimeUnit.MILLISECONDS), "Pong");
    }

    @Test(expected = ExecutionException.class)
    public void shouldReplyToUnknownMessageWithFailure() throws Exception {
        CompletableFuture<String> jFuture = askPong("unkown");
        jFuture.get(1000, TimeUnit.MILLISECONDS);
    }

    private CompletableFuture<String> askPong(String message) {
        Future future = ask(actorRef, message, 1000);
        final CompletionStage<String> cs = toJava(future);
        return cs.toCompletableFuture();
    }

}