package controller;

import java.util.*;
import java.io.*;
import model.*;
import view.*;

/**
 * @description A commande-line, turn-based chat program
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */
public class Chat {

    public static ChatController cc;

    public static void main(String[] args) {
        cc = new ChatController();
    }
}
