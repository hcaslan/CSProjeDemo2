package org.bilgeadam.util;

import org.bilgeadam.constant.MemurLevel;
import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.data.Memur;
import org.bilgeadam.data.Personel;
import org.bilgeadam.data.Yonetici;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputHelper {
    public static Scanner sc = new Scanner(System.in);

    public static String getStringInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public static int getIntegerInput(String message) {
        int input;
        while (true) {
            try {
                System.out.println(message);
                input = sc.nextInt();
                sc.nextLine();
                if(input>0)
                    break;
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_NEGATIVE_INTEGER.getMessage());
            } catch (InputMismatchException e) {
                sc.nextLine();
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_INTEGER.getMessage());
            }
        }
        return input;
    }

    public static MemurLevel getLevelInput(){
        String inputString = getStringInput(OutputMessage.GET_LEVEL_FROM_USER.getMessage());
        MemurLevel level = matchingLevel(inputString);
        while (level == null) {
            OutputHelper.errorMessage(OutputMessage.MEMUR_LEVEL_ERROR.getMessage());
            inputString = getStringInput(OutputMessage.GET_LEVEL_FROM_USER.getMessage());
            level = matchingLevel(inputString);
        }
        return level;
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
                    OutputHelper.errorMessage(OutputMessage.YONETICI_HOURLY_RATE_ERROR.getMessage());
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

    public static void getPersonelDataFromTerminal(List<Personel> personelList) {
        personelList.forEach(personel -> {
            System.out.println(personel.getName());
            personel.setWorkingHours(InputHelper.getIntegerInput(OutputMessage.GET_WORKING_HOUR_FROM_USER.getMessage()));
            if(personel instanceof Memur){
                ((Memur) personel).setLevel(InputHelper.getLevelInput());
            }
            if(personel instanceof Yonetici){
                ((Yonetici) personel).setHourlyRate(InputHelper.getHourlyRateForYonetici());
                ((Yonetici) personel).setBonus(InputHelper.getIntegerInput(OutputMessage.GET_BONUS_FROM_USER.getMessage()));
            }
        });
    }
}
