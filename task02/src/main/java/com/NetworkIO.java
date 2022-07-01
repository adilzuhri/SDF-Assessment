package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {

    private OutputStream os;
    private DataOutputStream dos;
    private InputStream is;
    private DataInputStream dis;

    public NetworkIO(Socket sock) throws IOException {
        os = sock.getOutputStream();
        dos = new DataOutputStream(os);
        is = sock.getInputStream();
        dis = new DataInputStream(is);
    }   

    public String read() throws IOException {
        return dis.readUTF();

    }

    public void write(String msg) throws IOException {
        dos.writeUTF(msg);
        dos.flush();
    }
    public void close() {
        try {
            dis.close();
            is.close();
            dos.close();
            os.close();
        } 
        catch (IOException ex) {

        }
    }
    
}
