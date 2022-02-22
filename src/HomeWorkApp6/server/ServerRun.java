package HomeWorkApp6.server;

import HomeWorkApp6.client.ClientReader;
import HomeWorkApp6.client.ClientWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerRun {
    private final int port = 8134;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Scanner read;
    private PrintWriter write;
    private Scanner consoleReader;

    public ServerRun() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            this.clientSocket = serverSocket.accept();
            System.out.println("Client connected...");
            this.read = new Scanner(clientSocket.getInputStream());
            this.write = new PrintWriter(clientSocket.getOutputStream());
            this.consoleReader = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runServer() {
        try {
            ServerReader serverReader = new ServerReader(serverSocket);
            ServerWriter serverWriter = new ServerWriter(serverSocket);

            serverWriter.start();
            serverReader.start();

            try {
                serverWriter.join();
                serverReader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            System.out.println("Server left chat...");
        }
    }

