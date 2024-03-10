package org.bilgeadam.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.data.MaasBordro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutputHelper {
    // ANSI escape code for red color
    static final String ANSI_RED = "\u001B[31m";

    // ANSI escape code for green color
    static final String ANSI_GREEN = "\u001B[32m";

    // ANSI escape code for yellow color
    static final String ANSI_YELLOW = "\u001B[33m";

    // ANSI escape code to reset the color
    static final String ANSI_RESET = "\u001B[0m";

    public static void errorMessage(String Message) {
        System.out.println(ANSI_RED + Message + ANSI_RESET);
    }

    public static void successMessage(String Message) {
        System.out.println(ANSI_GREEN + Message + ANSI_RESET);
    }

    public static void personnelUnderLimit(String Message){
        System.out.println(ANSI_YELLOW + Message + ANSI_RESET);
    }

    public static void printMenu(String... menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i) + "- " + menuItems[i]);
        }
    }

    public static void writeToJson(MaasBordro bordro) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = bordro.getPersonel().getName() + ".json";
        String folderName = bordro.getPersonel().getName();
        createFolder(folderName);
        try (FileWriter writer = new FileWriter(folderName + "\\" + fileName)) {
            gson.toJson(bordro, writer);
        } catch (IOException e) {
            OutputHelper.errorMessage((OutputMessage.ERROR.getMessage() + e.getCause()));
        }
    }
    public static void createFolder(String folderPathString){
        Path folderPath = Paths.get(folderPathString);
        try {
            Files.createDirectories(folderPath);
        } catch (Exception e) {
            OutputHelper.errorMessage((OutputMessage.ERROR.getMessage() + e.getCause()));
        }
    }
}
