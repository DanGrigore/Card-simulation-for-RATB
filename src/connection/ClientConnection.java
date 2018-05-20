package connection;

import models.Client;
import models.Card;

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

//        /**
//         * Add client works
//         */
//        Map toServer = new HashMap();
//        String whatToDo = "addClient";
//        Client aux = new Client();
//        aux.setFirstName("Dorel");
//        aux.setLastName("After");
//        toServer.put(whatToDo, aux);
//        os = new ObjectOutputStream(socket.getOutputStream());
//        os.writeObject(toServer);
//        /**
//         * pana aici
//         */

        Map toServer = new HashMap();
        String whatToDo = "chargePass";
        Card card = new Card();
        Client person = new Client();
        person.setFirstName("Dorel");
        person.setLastName("After");
        card.setPerson(person);
        card.setPass_type("recharge");
        card.setPass_price(25);

        toServer.put(whatToDo, card);
        os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject(toServer);



//        in = new ObjectInputStream(socket.getInputStream());
//
//        Object object = in.readObject();
//        String className = object.getClass().getName();
//
//        switch(className){
//            case "models.Client":
//                Client x = (Client) object;
//                System.out.println(x.getFirstName() + " " + x.getLastName());
//                break;
//            default:
//                System.out.println("Oops");
//        }
//        in.close();
        os.close();
        toServer.clear();
        socket.close();
    }


    public static void main(String[] args) throws Exception {
        ClientConnection client = new ClientConnection();
        client.connectToServer();
    }
}