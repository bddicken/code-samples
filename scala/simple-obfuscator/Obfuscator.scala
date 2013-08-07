package obfuscator

import scala.io._
import java.io._
import scala.util.Random

/**
 * Performs a very simple obfuscation of a .c file
 */
object Obfuscator extends App  {

    var ifile = ""
    var ofile = ""
    var out = ""
    var help = 
        "\n\n arguments: \n\t-i : file to obfuscate \n\t--inputfile : file to obfuscate\n" +
        "\n\t-o : output file name \n\t--outputfile : output file name\n"
    var defs = Array("A", "B", "C", "D", "E", "F", "G")
    var goodDef = " Z "
    var ifdef = "#ifdef "
    var endif = "#endif "
    var define = " -D "
    
    def parseArgs (arguments: Array[String]) = {
        for(i <- 0 until arguments.length) {
            if(arguments(i) == "-i" || arguments(i) == "--inputfile") {
                ifile = arguments(i=i+1)
            }
            if(arguments(i) == "-o" || arguments(i) == "--outputfile") {
                ofile = arguments(i=i+1)
            }
            if(arguments(i) == "--help" || arguments(i) == "-h") {
                println(help)
            }
        }
    }

    def obfuscateFile () = {
        var fileLines = Source.fromFile(ifile).getLines.toList
        var numLines = fileLines.length-1
        for (line <- fileLines) {
            
            // fake lines
            for (d <- defs) {
                var r = Random.nextInt(numLines)
                out += (ifdef + d + "\n" + fileLines(r) + "\n" + endif + "\n")
            }

            // the correct line
            out += ("\n" + ifdef + goodDef + "\n" + line + "\n" + endif + "\n")
        }

        val writer = new PrintWriter(new File(ofile))
        writer.write(out)
        writer.close()

        infoMessage
    }

    def infoMessage () = {
        println("\nFile sucesfully obfuscated.")
        println("Compile with the `-D Z` option to run working code.\n")
    }

    parseArgs(args)

    if(ifile != "" && ofile != "") {
        obfuscateFile
    }
}
