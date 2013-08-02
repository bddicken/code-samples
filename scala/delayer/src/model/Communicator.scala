package model

import scala.actors.Actor
import scala.actors.Actor._

import CommLevel._

class Shouter(cl: CommLevel, message: String, ms:Int) extends Actor {
    
    def act() {

        Thread.sleep(ms)

        var msg = "\n\n" + message + "\n\n"

        if(cl == shout)
            println(msg.toUpperCase)
        else if(cl == whisper)
            println(msg.toLowerCase)
        else
            println(msg)

        exit()
    }

}

