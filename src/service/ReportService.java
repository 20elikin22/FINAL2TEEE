package service;

import java.io.FileWriter;
import java.io.IOException;

public class ReportService {

    public void generateReport(String content) {

        try (FileWriter fw = new FileWriter("logs/report.txt")) {

            fw.write("=== LIBRARY REPORT ===\n");
            fw.write(content);

        } catch (IOException e) {
            System.out.println("Report generation failed.");
        }
    }
}