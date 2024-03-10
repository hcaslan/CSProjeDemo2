package org.bilgeadam.data;

public class PaymentDetail {
    private double mainPayment;
    private double additionalPayment;
    private double totalPayment;

    public PaymentDetail(double mainPayment, double additionalPayment, double totalPayment) {
        this.mainPayment = mainPayment;
        this.additionalPayment = additionalPayment;
        this.totalPayment = totalPayment;
    }

    public double getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(double mainPayment) {
        this.mainPayment = mainPayment;
    }

    public double getAdditionalPayment() {
        return additionalPayment;
    }

    public void setAdditionalPayment(double additionalPayment) {
        this.additionalPayment = additionalPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "mainPayment=" + mainPayment +
                ", additionalPayment=" + additionalPayment +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
