package org.bilgeadam.constant;

public enum MemurLevel {
    JUNIOR("JUNIOR",500),
    MID("MID",750),
    SENIOR("SENIOR",1000);
    private String stringValue;
    private int hourlyRate;
    MemurLevel(String stringValue, int hourlyRate) {
        this.stringValue = stringValue;
        this.hourlyRate = hourlyRate;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
