package connection;

import models.Client;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientConnection {

    private ObjectInputStream in;
    private ObjectOutputStream os;


    public void connectToServer() throws IOException, ClassNotFoundException {

        // Make connection and initialize streams
        Socket socket = new Socket("localhost", 7777);
        Map toServer = new HashMap();
        String whatToDo = "afisare";
        Client aux = new Client();
        toServer.put(whatToDo,aux);
        os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject(toServer);

        in = new ObjectInputStream(socket.getInputStream());

        Object object = in.readObject();
        String className = object.getClass().getName();

        switch(className){
            case "models.Client":
                Client x = (Client) object;
                System.out.println(x.getFirstName() + " " + x.getLastName());
                break;
            default:
                System.out.println("Oops");
        }
        in.close();
        os.close();
        toServer.clear();
        socket.close();
    }


    public static void main(String[] args) throws Exception {
        ClientConnection client = new ClientConnection();
        client.connectToServer();
    }
}