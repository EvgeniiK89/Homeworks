package HomeWorkApp6.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerRun {
    private final int port = 8134;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private static final Logger LOGGER = LogManager.getLogger(ServerRun.class);

    public ServerRun() {
        try {
            this.serverSocket = new ServerSocket(port);
            this.executorService = Executors.newFixedThreadPool(5);
            LOGGER.info("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runServer() {
        while (true) {
            try {
                executorService.submit(new ServerThread(serverSocket.accept()));
                LOGGER.info("Client connected!");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}

