import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws Exception {
        System.out.println("The server is running.");
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
                db.connect("SELECT * FROM CLIENT");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(db.connect("SELECT * FROM CLIENT"));
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
