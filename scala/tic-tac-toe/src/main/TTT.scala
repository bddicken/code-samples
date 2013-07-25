package main

import model._

/**
 * The tic-tac-toe game
 */
object TTT extends App {

    var board = new Board

    var px = new Player("X", "X")
    var py = new Player("Y", "Y")

    var cp = px;

    def makeMove (p:Player) = {
           
        var read = true
        
        var x = 0
        var y = 0

        println(p.name + ", it's your turn, time to make your move.")
    
        while(read) {

            try {
                print("x position: ")
                x = readLine().toInt
            
                print("y position: ")
                y = readLine().toInt
            } catch {
                case ex:Exception => {
                    println("Invalid move, try again!")
                }
            }

            var move = board.placeSymbol(p.symbol, x, y)

            if(move == false) 
                println("Invalid move, try again!")
            else
                read = false
        }
    }

    def playGame () = {

        println("\nWelcome to Tic-Tac-Toe!")

        var play = true

        while(play) {
            makeMove(cp)
            
            board.printBoard() 

            if(board.isOver) {
                println("\nplayer " + cp.name + " wins!\n")
                play = false
            }

            if(cp == px) cp = py
            else cp = px
        }
    }

    // Begin game
    playGame()
    
}
