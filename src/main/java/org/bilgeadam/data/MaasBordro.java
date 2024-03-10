package org.bilgeadam.data;

import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.util.Generator;
import org.bilgeadam.util.OutputHelper;

import java.io.Serializable;
import java.util.List;

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
                "bordro='" + bordro + '\'' +
                ", personel=" + personel +
                '}';
    }

    public String getBordro() {
        return bordro;
    }

    public Personel getPersonel() {
        return personel;
    }

    public static void displayBordro(List<MaasBordro> maasBordroList){
        System.out.println(OutputMessage.MAAS_BORDROLARI.getMessage());
        maasBordroList.forEach(bordro -> {
            if(bordro.getPersonel().getWorkingHours() < 10){
                OutputHelper.personnelUnderLimit((OutputMessage.UNDER_WORKING_HOUR_LIMIT_2.getMessage() + System.lineSeparator() + bordro));
            } else if(bordro.getPersonel().getWorkingHours() < 150){
                OutputHelper.personnelUnderLimit((OutputMessage.UNDER_WORKING_HOUR_LIMIT_1.getMessage() + System.lineSeparator() + bordro));
            }else
                System.out.println(bordro);
        });
    }
    public static void createBordroList(List<Personel> personelList, List<MaasBordro> maasBordroList) {
        personelList.forEach(personel -> {
            maasBordroList.add(new MaasBordro(Generator.dateGenerator(), personel));
        });
    }

    public static void writeBordroToJson(List<MaasBordro> maasBordroList){
        maasBordroList.forEach(OutputHelper::writeToJson);
    }
}
