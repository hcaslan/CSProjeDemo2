package org.bilgeadam.data;

public class PaymentDetail {
    private double mainPayment;
    private double overtime;
    private double totalPayment;

    public PaymentDetail(double mainPayment, double overtime, double totalPayment) {
        this.mainPayment = mainPayment;
        this.overtime = overtime;
        this.totalPayment = totalPayment;
    }

    public double getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(double mainPayment) {
        this.mainPayment = mainPayment;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
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
                ", overtime=" + overtime +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
