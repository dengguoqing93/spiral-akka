package org.spiral.myakka;

import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * actor系统启动类
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("akkademy");
        system.actorOf(Props.create(AkkademyDB.class), "akkademy-db");
    }
}
