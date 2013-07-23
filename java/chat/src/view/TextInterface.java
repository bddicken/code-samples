package view;

import java.util.*;
import java.io.*;

/**
 * @description
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */
public class TextInterface {

    public TextInterface() {
        // nothing for now
    }

    public String welcome() {
        System.out.println("Welcome to the interactive chat program.");
        String hj = getCLIInput("Would you like to host a chat or join a chat (h/j))? ");
        return hj;
    }

    public String requestUsername() {
        return getCLIInput("Please enter your username: ");
    }

    public String requestConnectIP() {
        return getCLIInput("What IP would you like to connect to?: ");
    }
    
    public int requestConnectPort() {
        String sPort = getCLIInput("What Port would you like to connect to?: ");
        return Integer.parseInt(sPort);
    }
    
    public int requestHostPort() {
        String sPort = getCLIInput("What Port would you like to host a server on?: ");
        return Integer.parseInt(sPort);
    }
    
    public String requestMessage() {
        return getCLIInput(">> ");
    }

    public String requestBroadCastMessage() {
        return getCLIInput("Message to breoadcast to clients: ");
    }

    public String getCLIInput(String request)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = null;
        System.out.print(request);
        try {
            result = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read input!");
            System.exit(1);
        }
        return result;
    }
}
