package server;

import models.Card;
import models.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Server {

    public static void main(String[] args) throws Exception {
        System.out.println("Server running.");
        ServerSocket listener = new ServerSocket(7777);
        try {
            while (true) {
                new ServerConnection(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class ServerConnection extends Thread {
        private Socket socket;

        public ServerConnection(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataBase db = DataBase.getInstance();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Map welcome = new HashMap();
                try {
                    welcome = (HashMap) in.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (welcome.containsKey("afisare")) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(db.printClients());
                }

                if (welcome.containsKey("addClient")) {
                    Client newClient = (Client) welcome.get("addClient");
                    db.createClient(newClient.getFirstName(), newClient.getLastName());
                }

                if(welcome.containsKey("chargePass")){
                    Card card = (Card) welcome.get("chargePass");
                    db.chargePass(card);
                }
            } catch (IOException e) {

            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Couldn't close a socket");
                }
            }
        }

        private void log(String message) {
            System.out.println(message);
        }
    }
}
