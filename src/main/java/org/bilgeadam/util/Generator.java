package org.bilgeadam.util;

import org.bilgeadam.constant.MemurLevel;
import org.bilgeadam.constant.Month;

import java.time.LocalDate;
import java.util.Locale;

public class Generator {
    public static String dateGenerator(){
        LocalDate localDateNow = LocalDate.now();
        return matchingMonth(localDateNow.getMonthValue()).toString() + " " + localDateNow.getYear();
    }
    private static Month matchingMonth(int input){
        Month matchingEnum = null;
        for (Month enumValue : Month.values()) {
            if (enumValue.getMonth() == input) {
                matchingEnum = enumValue;
                break;
            }
        }
        return matchingEnum;
    }
}
