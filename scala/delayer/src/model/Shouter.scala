
package model

import scala.actors.Actor
import scala.actors.Actor._

object CommLevel extends Enumeration {
    type CommLevel = Value
    val whisper, speak, shout = Value
}

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

object Main extends App {
        
    var msg = ""
    var ctype = speak
    var delay = 0
   
    def stringToCommLevel(value: String): CommLevel = value match {
        case "whisper" => whisper
        case "speak" => speak
        case "shout" => shout
    }
    
    def makeMove () = {
           
        var read = true

        while(read) {

            try {
                print("Your message: ")
                msg = readLine()
            
                print("Type (whisper, speak, or shout): ")
                var typeString = readLine()

                if(typeString == "whisper" ||
                   typeString == "speak"   ||
                   typeString == "shout")
                {
                    ctype = stringToCommLevel(typeString) 
                } else {
                    throw new Exception 
                }
                
                print("Delay: ")
                delay = readLine().toInt
            
                read = false

            } catch {
                case ex:Exception => {
                    println("Invalid input, please try again.")
                }
            }

        }
    }


    def begin () = {
        while(true) {
            makeMove
            var s = new Shouter(ctype, msg, delay)
            s.start
        }
    }

    begin
}

