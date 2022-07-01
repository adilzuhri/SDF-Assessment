package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    
   public static void main(String[] args) throws IOException {

        int port = 80;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);

    //Creating server
    System.out.printf("Starting the server on port %d\n", port);
    try (ServerSocket server = new ServerSocket(port)) {
        while (true) {
        //Establishing connectiong
            System.out.println("waiting for client connectiong");
            Socket sock = server.accept();
            System.out.println("Connected!");
        }
    }    
    }
    
} 

