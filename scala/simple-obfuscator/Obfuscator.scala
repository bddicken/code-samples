import scala.io.Source

/**
 * Program to test command line argument parsing.
 *
 * Accepts arguments:
 *      (-v || --verbose) 
 *      (-h || --help) 
 */
object CLA extends App  {

    var file = ""
    var help = "\n\n arguments: \n\t-i : file to obfuscate \n\t--inputfile : file to obfuscate\n"
    
    def parseArgs (arguments: Array[String]) = {
        
        for(i <- 0 until arguments.length) {
            
            if(arguments(i) == "-i" || arguments(i) == "--inputfile") {
                verbose = arguments(i=i+1)
                println("VERBOSE: " + verbose)
            }
            
            if(arguments(i) == "--help" || arguments(i) == "-h") {
                println(help)
            }
        
        }
    }

    def loopFile () = {
        val fileLines = Source.fromFile(filename).getLines.toList
    }

    parseArgs(args)
}
