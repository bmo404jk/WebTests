package utils;

import java.io.File;
import java.io.IOException;

public class AllureListener {

    public static void openAllureReport() throws IOException {

        String allurePath = "src/main/java/AllureFiles/bin/allure.bat";
        String resultsDir = "target/allure-results";

        try {
            Process process = new ProcessBuilder(allurePath, "serve", resultsDir)
                    .directory(new File(System.getProperty("user.dir")))
                    .start();
            process.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to open Allure report", e);
        }
    }
}