package org.bilgeadam.util;

import org.bilgeadam.constant.MemurLevel;
import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.data.Yonetici;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static Scanner sc = new Scanner(System.in);

    public static String getStringInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public static int getIntegerInput(String message) {
        System.out.println(message);
        int input;
        while (true) {
            try {
                input = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_INTEGER.getMessage());
            }
        }
        return input;
    }

    public static LocalDate getLocalDateInput() {
        LocalDate localDate;
            try {
                localDate = LocalDate.parse(
                        getIntegerInput(OutputMessage.GET_YEAR_FROM_USER.getMessage()) + "-" +
                                getIntegerInput(OutputMessage.GET_MONTH_FROM_USER.getMessage()) + "-" +
                                getIntegerInput(OutputMessage.GET_DAY_FROM_USER.getMessage()));
                return localDate;
            } catch (DateTimeParseException e) {
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_LOCAL_DATE.getMessage());
                getLocalDateInput();
            }
            return null;
    }
    public static MemurLevel getLevelInput(){
        return matchingLevel(getStringInput(OutputMessage.GET_LEVEL_FROM_USER.getMessage()));
    }
    private static MemurLevel matchingLevel(String inputString){
        MemurLevel matchingEnum = null;
        for (MemurLevel enumValue : MemurLevel.values()) {
            if (enumValue.getStringValue().equals(inputString)) {
                matchingEnum = enumValue;
                break;
            }
        }
        return matchingEnum;
    }
    public static int getHourlyRateForYonetici(){
        System.out.println(OutputMessage.GET_HOURLY_RATE_FROM_USER.getMessage());
        int input;
        while (true) {
            try {
                input = sc.nextInt();
                sc.nextLine();
                if(input< Yonetici.MIN_HOURLY_RATE){
                    System.out.println("500 den küçük olamaz.");
                    getHourlyRateForYonetici();
                }
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_INTEGER.getMessage());
            }
        }
        return input;
    }
}
