
package main

import scala.actors.Actor
import scala.actors.Actor._

import model._
import model.CommLevel._

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

        println("Go ahead, send a message!")
           
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

