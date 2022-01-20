package HomeWorkApp6.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriter extends Thread {
    private Scanner consoleReader;
    private PrintWriter write;

    public ClientWriter(Socket socket) throws IOException {
        this.consoleReader = new Scanner(System.in);
        this.write = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            String outputLine = consoleReader.nextLine();
            write.println(outputLine);
            write.flush();
        }
    }

}
