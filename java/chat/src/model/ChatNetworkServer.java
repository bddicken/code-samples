package model;

import java.net.*;
import java.util.*;
import java.io.*;

/**
 * @description
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */
public class ChatNetworkServer {

    public int port;
    public ServerSocket ss;
    public Socket cs;
    public PrintWriter pw;
    public BufferedReader br;

    public ChatNetworkServer(int port) {
        this.port = port;

        try {
            ss = new ServerSocket(port);
            System.out.println("Waiting for client to connect...");
            cs = ss.accept();
            pw = new PrintWriter(cs.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            System.out.println("Client connected!...");
        } catch (Exception e) {
            System.out.println("Client failed to connect to server");
        }
    }

    public void sendMessage(String message) {
        pw.println(message);
    }

}
