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
        
        var xs = ""
        var ys = ""
        var x = 0
        var y = 0

        println(p.name + ", it's your turn!")
    
        while(read) {

            print("x: ")
            x = readLine().toInt
            
            print("y: ")
            x = readLine().toInt

            var move =  board.placeSymbol(p.symbol, x, y)

            if(move == false) 
                println("Invalid move, try again!")
            else
                read = false
        }
    }

    def playGame () = {
        var play = true

        while(play) {
            makeMove(cp)     

            if(cp == px) cp = py
            else cp = px
        }
    }

    // Begin game
    playGame()
    
}
