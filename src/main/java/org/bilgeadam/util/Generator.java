package org.bilgeadam.util;

import org.bilgeadam.constant.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Objects;

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
    public static Path createFilePath(String dosyaAdi) {
        ClassLoader classLoader = DosyaOku.class.getClassLoader();
        URL resource = classLoader.getResource(dosyaAdi);
        try {
            return Paths.get(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException | NullPointerException e) {
            OutputHelper.errorMessage((OutputMessage.ERROR.getMessage() + e.getCause()));
        }
        return null;
    }
}
