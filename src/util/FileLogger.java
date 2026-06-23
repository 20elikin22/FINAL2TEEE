package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger {

    public static void log(String action) {

        try (FileWriter fw = new FileWriter("logs/activity.log", true)) {

            fw.write(LocalDateTime.now() + " - " + action + "\n");

        } catch (IOException e) {
            System.out.println("Logging failed.");
        }
    }
}