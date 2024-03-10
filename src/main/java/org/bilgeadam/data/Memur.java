package org.bilgeadam.data;

import org.bilgeadam.constant.MemurLevel;
import org.bilgeadam.constant.Role;

import java.util.logging.Level;

public class Memur extends Personel{
    private static final int MAX_WORKING_HOUR = 180;
    private static final double OVERTIME_FACTOR = 1.5;
    private transient  MemurLevel level;

    public Memur(String name, String surname, Role role) {
        super(name, surname, role);
    }

    public MemurLevel getLevel() {
        return level;
    }

    public void setLevel(MemurLevel memurLevel) {
        this.level = memurLevel;
    }

    @Override
    public void maasHesapla() {
        double mainPayment = 0;
        double overtime = 0;
        double totalPayment = 0;
        if(super.getWorkingHours() <=MAX_WORKING_HOUR){
            mainPayment = super.getWorkingHours()* this.level.getHourlyRate();
        }else if(super.getWorkingHours() > MAX_WORKING_HOUR){
            mainPayment = super.getWorkingHours()* this.level.getHourlyRate();
            overtime = (super.getWorkingHours()-MAX_WORKING_HOUR)*(OVERTIME_FACTOR*this.level.getHourlyRate());
            totalPayment = mainPayment+overtime;
        }
        super.setPaymentDetail(new PaymentDetail(mainPayment, overtime, totalPayment));
    }

    @Override
    public String toString() {
        return "Memur{" +
                super.toString() +
                ", level=" + level +
                '}';
    }
}
