import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientConnection {

    private DataInputStream in;


    public void connectToServer() throws IOException {

        // Make connection and initialize streams
        Socket socket = new Socket("localhost", 7777);
        in = new DataInputStream(socket.getInputStream());

        System.out.println(in.readUTF());
    }


    public static void main(String[] args) throws Exception {
        ClientConnection client = new ClientConnection();
        client.connectToServer();
    }
}