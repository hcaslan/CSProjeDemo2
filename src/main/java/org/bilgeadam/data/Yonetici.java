package org.bilgeadam.data;

import org.bilgeadam.constant.Role;

public class Yonetici extends Personel{
    public static final int MIN_HOURLY_RATE = 500;
    private transient  int hourlyRate;
    private transient  int bonus;
    public Yonetici(String name, String surname, Role role) {
        super(name, surname, role);
    }

    @Override
    public void maasHesapla() {
        double mainPayment = super.getWorkingHours()*this.hourlyRate;
        double bonus = this.bonus;
        double totalPayment = mainPayment+bonus;

        super.setPaymentDetail(new PaymentDetail(mainPayment, bonus, totalPayment));
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }




    @Override
    public String toString() {
        return "Yonetici{" +
                super.toString() +
                "}";
    }
}
