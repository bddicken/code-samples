package controller;

import java.util.*;
import java.io.*;
import model.*;
import view.*;

/**
 * @description
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */
public class ChatController {

    public String username;
    public TextInterface iF;

    public ChatController() {
        iF = new TextInterface();
        BeginProgram();
    }

    public void BeginProgram() {
        String hj = iF.welcome();
        if(hj.toLowerCase().indexOf("j") != -1) {
            this.initClientConversation();
        }
        else {
            this.initServerConversation();
        }
    }

    public void initClientConversation() {
        String ip = iF.requestConnectIP();
        int port = iF.requestConnectPort();
        System.out.println("Connecting to server...");
        ChatNetworkClient client = new ChatNetworkClient(ip, port);
        System.out.println("Connected!");
        
        boolean myTurn = false;
        
        while(true) {
            if(myTurn) {
                client.sendMessage(iF.requestMessage());
                myTurn = false;
            } else {
                try {
                    String userInput;
                    while ((userInput = client.br.readLine()) == null) {
                    }
                    System.out.println("reply: " + userInput);
                    myTurn = true;
                } catch(Exception e) {
                    System.out.println("io exception, exiting...");
                    System.exit(1);
                }
            }
        }
    }

    public void initServerConversation() {
        int port = iF.requestHostPort();
        System.out.println("Setting up server poopy...");
        ChatNetworkServer server = new ChatNetworkServer(port);
        System.out.println("Server now set up!");
        
        boolean myTurn = true;
        
        while(true) {
            if(myTurn) {
                server.sendMessage(iF.requestMessage());
                myTurn = false;
            } else {
                try {
                    String userInput;
                    while ((userInput = server.br.readLine()) == null) {
                    }
                    System.out.println("reply:" + userInput);
                    myTurn = true;
                } catch(Exception e) {
                    System.out.println("io exception, exiting...");
                    System.exit(1);
                }
            }
        }
    }
}

