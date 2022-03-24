package HomeWorkApp6.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

    private Scanner read;
    private PrintWriter write;
    private Scanner consoleReader;
    private Socket clientSocket;
    private static final Logger LOGGER = LogManager.getLogger(ServerThread.class);

    public ServerThread(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        LOGGER.info("New client connected!");
        try {
            this.read = new Scanner(clientSocket.getInputStream());
            this.write = new PrintWriter(clientSocket.getOutputStream());
            this.consoleReader = new Scanner(System.in);

            ServerReader serverReader = new ServerReader(read, write);
            ServerWriter serverWriter = new ServerWriter(write);

            serverWriter.start();
            serverReader.start();

            try {
                serverWriter.join();
                serverReader.join();
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
