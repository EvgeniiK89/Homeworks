package HomeWorkApp6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

import static HomeWorkApp6.server.db.DBUtils.auth;

public class ServerReader extends Thread {

    private PrintWriter writer;
    private Scanner read;

    public ServerReader (Scanner read, PrintWriter write) throws IOException {
        this.read = read;
        this.writer = write;
    }

    @Override
    public void run() {
        while (true) {
            if (read.hasNextLine()) {
                String inputLine = read.nextLine();
                if (inputLine.equals("/end")) {
                    break;
                }
                if (inputLine.contains("/auth")) {
                    String[] params = inputLine.split(" ");// /auth login pass -> ["/auth", "login", "pass"]
                    String login = params[1];
                    String pass = params[2];
                    if (auth(login, pass)) {
                        writer.println("Login success");
                        writer.flush();
                    } else {
                        writer.println("login failed!");
                        writer.flush();
                    }
                }
                System.out.println("Client message : " + inputLine);
            }
        }
    }
}


