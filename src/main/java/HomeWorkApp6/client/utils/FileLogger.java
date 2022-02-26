package HomeWorkApp6.client.utils;

import java.io.*;

public class FileLogger {
    private static FileLogger instance;
    private PrintWriter printWriter;

    private FileLogger() {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\HomeWorkApp6\\client\\Message.log");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("cannot create file!");
            }
        }
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath(), true)));
        } catch (IOException e) {
            throw new RuntimeException("cannot find file!");
        }
    }

    public static synchronized FileLogger getInstance() {
        if (instance == null) {
            instance = new FileLogger();
        }
        return instance;
    }

    public void logMessage(String message) {
        if (printWriter != null) {
            printWriter.append(message).append("\n");
            printWriter.flush();
        }
    }

    public void closeFileLogger() {
        printWriter.close();
    }
}
