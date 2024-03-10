package org.bilgeadam.constant;

public enum OutputMessage {
    ERROR("Something went wrong!"),
    SUCCESS("Operation successful."),
    SELECT("Select :"),
    MAAS_BORDROLARI("MAAS BORDROLARI:"),
    GET_WORKING_HOUR_FROM_USER("Working hours of the personel :"),
    GET_LEVEL_FROM_USER("Level (JUNIOR,MID,SENIOR) :"),
    GET_HOURLY_RATE_FROM_USER("Hourly rate of Yonetici :"),
    GET_BONUS_FROM_USER("Bonus :"),
    YONETICI_HOURLY_RATE_ERROR("Yonetici hourly rate must be higher than 500 :"),
    MEMUR_LEVEL_ERROR("Incorrect Input. Try Again."),
    UNDER_WORKING_HOUR_LIMIT_1("Under Working Hour Limit (10-150)"),
    UNDER_WORKING_HOUR_LIMIT_2("Under Working Hour Limit (0-10)"),
    INPUT_MISMATCH_INTEGER("Enter an integer."),
    INPUT_MISMATCH_NEGATIVE_INTEGER("Cannot be Negative."),
    ;
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
