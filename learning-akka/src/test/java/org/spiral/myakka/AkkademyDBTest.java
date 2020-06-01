package org.spiral.myakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Test;
import org.spiral.myakka.message.SetRequest;

import static junit.framework.TestCase.assertEquals;


/**
 * AkkademyDB Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 1, 2020</pre>
 */
public class AkkademyDBTest {

    ActorSystem system = ActorSystem.create();


    /**
     * Method: createReceive()
     */
    @Test
    public void testCreateReceive() throws Exception {
        TestActorRef<AkkademyDB> actorRef = TestActorRef.create(system, Props.create(AkkademyDB.class));
        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
        AkkademyDB akkademyDB = actorRef.underlyingActor();
        assertEquals(akkademyDB.map.get("key"), "value");


    }


} 
