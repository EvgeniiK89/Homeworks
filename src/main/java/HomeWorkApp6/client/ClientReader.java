package HomeWorkApp6.client;

import HomeWorkApp6.client.utils.FileLogger;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientReader extends Thread {

    private Scanner read;

    public ClientReader(Socket socket) throws IOException {
        this.read = new Scanner(socket.getInputStream());
    }

    @Override
    public void run() {
        FileLogger fileLogger = FileLogger.getInstance();
        while (true) {
            if (read.hasNextLine()) {
                String inputLine = read.nextLine();
                if (inputLine.equals("/end")) {
                    break;
                }
                String message = "Server message : " + inputLine;
                System.out.println(message);
                fileLogger.logMessage(message);
            }
        }
    }
}
