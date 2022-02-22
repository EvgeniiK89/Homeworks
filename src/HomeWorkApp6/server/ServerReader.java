package HomeWorkApp6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerReader extends Thread {

    private Scanner read;

    public ServerReader (ServerSocket serverSocket) throws IOException {
        this.read = new Scanner(serverSocket.accept().getInputStream());
    }

    @Override
    public void run() {
        while (true) {
            if (read.hasNext()) {
                String inputLine = read.next();
                if (inputLine.equals("/end")) {
                    break;
                }
                System.out.println("Client message : " + inputLine);
            }
        }
    }
}


