/**
 * Program to test command line argument parsing.
 */
object CLA {

    String varbose = "none";

    def main (args: Array[String]) = {
        parseArgs(args);
    }

    def parseArg (arguments: Array[String]) {
        
        int index = 0;
        
        for(String a <- arguments) {
            
            if(argument == "--verbose" || argument == "-v") {
                verbose = arguments[++index];
                println("VERBOSE: " + verbose);
            }

            ++index;
        }
    }
}
