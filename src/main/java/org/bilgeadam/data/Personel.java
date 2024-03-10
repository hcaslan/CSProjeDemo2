package org.bilgeadam.data;

import org.bilgeadam.constant.Role;

public abstract class Personel {
    private String name;
    private transient String surname;
    private transient Role role;
    private int workingHours;
    private PaymentDetail paymentDetail;

    public Personel(String name, String surname, Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public abstract void maasHesapla();

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                        ", " + paymentDetail;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Role getRole() {
        return role;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }
}
