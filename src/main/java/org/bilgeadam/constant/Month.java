package org.bilgeadam.constant;

public enum Month {
    OCAK(1),
    SUBAT(2),
    MART(3),
    NISAN(4),
    MAYIS(5),
    HAZIRAN(6),
    TEMMUZ(7),
    AGUSTOS(8),
    EYLUL(9),
    EKIM(10),
    KASIM(11),
    ARALIK(12);

    private int order;

    private Month(int ayNumarasi) {
        this.order = ayNumarasi;
    }

    public int getMonth() {
        return order;
    }
}
