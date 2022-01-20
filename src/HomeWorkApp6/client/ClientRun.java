package HomeWorkApp6.client;

import java.io.IOException;
import java.net.Socket;

public class ClientRun {

    private final String server = "localhost";
    private final int port = 8134;
    private Socket socket;

    public ClientRun() {
        try {
            this.socket = new Socket(server, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runClient() {
        try {
            ClientReader reader = new ClientReader(socket);
            ClientWriter writer = new ClientWriter(socket);

            reader.start();
            writer.start();

            try {
                writer.join();
                reader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client left chat...");
    }
}
