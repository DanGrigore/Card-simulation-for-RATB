package server;

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
                DataBase db = new DataBase();
                // db.connect("SELECT * FROM CLIENT");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Map welcome = new HashMap();
                try {
                    welcome = (HashMap) in.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (welcome.containsKey("afisare")) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(db.connect("SELECT * FROM CLIENT"));
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
