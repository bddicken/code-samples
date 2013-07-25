package model

/**
 * The game board.
 */
class Board () {
   
    var board = Array(Array("", "", ""), Array("", "", ""), Array("", "", ""))
   
    /**
     * Determine if the game is over
     */ 
    def isOver () : Boolean = {
        
        // Rows and Columns
        for(i <- 0 until 3) {
            if( (board(i)(0) == board(i)(1)) &&
                (board(i)(1) == board(i)(2)) &&
                (board(i)(0) != " ") ) {
                return true;
            }
            
            if( (board(0)(i) == board(1)(i)) &&
                (board(1)(i) == board(2)(i)) &&
                (board(0)(i) != " ") ) {
                return true;
            }
        }

        // Negative Diagonal
        if( (board(0)(0) == board(1)(1)) &&
            (board(1)(1) == board(2)(2)) &&
            (board(0)(0) != " ") ) {
            return true;
        }

        // Positive Diagonal
        if( (board(0)(3) == board(1)(1)) &&
            (board(1)(1) == board(2)(0)) &&
            (board(0)(0) != " ") ) {
            return true;
        }

        return false

    }

    /**
     * Place symbol on board
     */
    def placeSymbol (sym:String, x:Int, y:Int) : Boolean = {
        if(x > 0 && x < 4 && y > 0 && y < 4 ) {
            board(x-1)(y-1) = sym
            return true
        } 
        else {
            return false
        }
    }

    /**
     * Print the game board.
     */
    def printBoard () = {
        for (i <- 0 until 3) {
            println("|" + board(i)(0) + "|" + board(i)(1) + "|" + board(i)(2) + "|")
            if(i != 2)
                println("-------")
        }
    }

}
