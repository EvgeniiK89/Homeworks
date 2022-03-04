package HomeWorkApp6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerRun {
    private final int port = 8134;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public ServerRun() {
        try {
            this.serverSocket = new ServerSocket(port);
            this.executorService = Executors.newFixedThreadPool(5);
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runServer() {
        while (true) {
            try {
                executorService.submit(new ServerThread(serverSocket.accept()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

