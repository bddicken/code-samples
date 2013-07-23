package model;

import java.net.*;
import java.util.*;
import java.io.*;

/**
 * @description
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */
public class ChatNetworkClient {

    public String ip;
    public int port;
    public Socket cs;
    public PrintWriter pw;
    public BufferedReader br;

    public ChatNetworkClient(String ip, int port) {
        this.ip = ip;
        this.port = port;

        try {
            cs = new Socket(ip, port);
            pw = new PrintWriter(cs.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        } catch (Exception e) {
            System.out.println("Client failed to connect to server");
        }
    }

    public void sendMessage(String message) {
        pw.println(message);
    }

}
