package org.bilgeadam.data;

import java.io.Serializable;

public class MaasBordro implements Serializable {
    private String bordro;
    private Personel personel;

    public MaasBordro(String bordro, Personel personel) {
        this.personel = personel;
        this.bordro = bordro;
    }

    @Override
    public String toString() {
        return "MaasBordro{" +
                "date='" + bordro + '\'' +
                ", personel=" + personel +
                '}';
    }
}
