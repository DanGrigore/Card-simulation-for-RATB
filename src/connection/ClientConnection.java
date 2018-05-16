package connection;

import java.io.*;
import java.net.Socket;

public class ClientConnection {

    private ObjectInputStream in;
    private ObjectOutputStream os;


    public void connectToServer() throws IOException, ClassNotFoundException {

        // Make connection and initialize streams
        Socket socket = new Socket("localhost", 7777);
        in = new ObjectInputStream(socket.getInputStream());

       // models.Client x = (models.Client) in.readObject();
       // System.out.println(x.getFirstName() + " " + x.getLastName());
        String className = in.readObject().getClass().getName();
        System.out.println(className);
        in.close();
    }


    public static void main(String[] args) throws Exception {
        ClientConnection client = new ClientConnection();
        client.connectToServer();
    }
}