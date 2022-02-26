package HomeWorkApp6.client.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoaderMessages {
    public static void recoverMessages() {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\HomeWorkApp6\\client\\Message.log");
        if (!file.exists()) {
            System.out.println("cannot find file to recover messages");
        } else {
            try {
                Scanner scanner = new Scanner(file);
                int count = 0;
                while (scanner.hasNextLine() && count < 100) {
                    System.out.println(scanner.nextLine());
                    count++;
                }
                System.out.println("Chat recovered!");
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
