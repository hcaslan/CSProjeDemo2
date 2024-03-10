package org.bilgeadam.constant;

public enum OutputMessage {
    ERROR("Something went wrong!"),
    SUCCESS("Operation successful."),
    SELECT("Select :"),
    GET_WORKING_HOUR_FROM_USER("Working hours of the personal :"),
    GET_LEVEL_FROM_USER("Level (JUNIOR,MID,SENIOR) :"),
    GET_HOURLY_RATE_FROM_USER("Hourly rate of Yonetici :"),
    GET_BONUS_FROM_USER("Bonus :"),
    GET_AUTHOR_FROM_USER("Book Author :"),
    GET_KEYWORD_FROM_USER("Keyword to search :"),
    GET_YEAR_FROM_USER("Year : "),
    GET_MONTH_FROM_USER("Month : "),
    GET_DAY_FROM_USER("Day : "),
    INVALID_OPERATION("Invalid operation."),
    INPUT_MISMATCH_INTEGER("Enter an integer :"),
    INPUT_MISMATCH_LOCAL_DATE("Incorrect date."),
    USERNAME_TAKEN("Username already taken !"),
    LOGIN_SUCCESS("Logged In."),
    REGISTER_SUCCESS("Successfully registered."),
    LOGIN_ERROR("Username or password incorrect."),
    EMPTY_LIST("Nothing to show."),
    BOOK_NOT_AVAILABLE("Book cannot be lent.")
    ;
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
