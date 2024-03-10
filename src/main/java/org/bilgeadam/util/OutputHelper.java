package org.bilgeadam.util;

import com.google.gson.Gson;
import org.bilgeadam.data.MaasBordro;
import org.bilgeadam.data.Personel;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class OutputHelper<T> {
    static final String ANSI_RED = "\u001B[31m";
    // ANSI escape code for green color
    static final String ANSI_GREEN = "\u001B[32m";
    // ANSI escape code to reset the color
    static final String ANSI_RESET = "\u001B[0m";

    public static void errorMessage(String Message) {
        System.out.println(ANSI_RED + Message + ANSI_RESET);
    }

    public static void successMessage(String Message) {
        System.out.println(ANSI_GREEN + Message + ANSI_RESET);
    }

    public static void printMenu(String... menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i) + "- " + menuItems[i]);
        }
    }

    public static void writeToJson(List<MaasBordro> maasBordroList) {
        Gson gson = new Gson();
        File file = new File("output.json");
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(maasBordroList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
