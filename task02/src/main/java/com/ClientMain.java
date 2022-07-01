package com;

import java.io.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int port = 80;
        if (args.length >=2) {
            host = args [0];
            port = Integer.parseInt(args[1]);
        } else if (args.length == 1)
            port = Integer.parseInt(args[0]);

        //Establishin connection to server
        System.out.printf("Connect to server %s on port %d\n", host, port);
        Socket sock = new Socket(host, port);
        System.out.println("Connected!");

        public static void main(String[] args) throws IOException {
            Socket s = new Socket("localhost", 80);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

        }

        NetworkIO netIO = new NetworkIO(sock);
        Console cons = System.console();
        String req = "";
        String resp = "";
        String response = read();
        System.out.println(response);
        

        while (!req.equals("exit")) {
            req = cons.readLine("> ");
            if (req.trim().equals("exit")) break;
            netIO.write(req);
            resp = netIO.read ();
            System.out.printf(">> %s\n", resp);

        }

        private String read[()] throws IOException {
            return ois.readUTF();

        }

        private void write(String out) throws IOException {
            oos.writeUTF(out);
            oos.flush();
        }

        private void close() throws IOException {
            is.close();
            os.close();

        }
        netIO.close();
        sock.close();

        System.out.println("Failed");

    

        }

    private static String read() {
        return null;
    }

}


