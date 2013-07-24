/**
 * Program to test command line argument parsing.
 *
 * Accepts arguments:
 *      (-v || --verbose) 
 *      (-h || --help) 
 */
object CLA extends App  {

    var verbose = "none"
    var help = "none"
    
    def parseArgs (arguments: Array[String]) = {
        
        for(i <- 0 until arguments.length) {
            
            if(arguments(i) == "--verbose" || arguments(i) == "-v") {
                verbose = arguments(i=i+1)
                println("VERBOSE: " + verbose)
            }
            
            if(arguments(i) == "--help" || arguments(i) == "-h") {
                help = arguments(i=i+1)
                println("HELP: " + help)
            }
        
        }
    }

    parseArgs(args)
}
