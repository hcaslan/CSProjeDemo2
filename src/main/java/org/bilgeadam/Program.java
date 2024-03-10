package org.bilgeadam;

import org.bilgeadam.constant.OutputMessage;
import org.bilgeadam.data.Memur;
import org.bilgeadam.data.Personel;
import org.bilgeadam.data.Yonetici;
import org.bilgeadam.util.DosyaOku;
import org.bilgeadam.util.InputHelper;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DosyaOku dosyaOku = new DosyaOku();
        List<Personel> personelList= dosyaOku.readFromJson();
        personelList.forEach(personel -> {
            System.out.println(personel.getName());
            personel.setWorkingHours(InputHelper.getIntegerInput(OutputMessage.GET_WORKING_HOUR_FROM_USER.getMessage()));
            if(personel instanceof Memur){
                ((Memur) personel).setLevel(InputHelper.getLevelInput());
            }
            if(personel instanceof Yonetici){
                ((Yonetici) personel).setHourlyRate(InputHelper.getHourlyRateForYonetici());
                ((Yonetici) personel).setBonus(InputHelper.getIntegerInput(OutputMessage.GET_BONUS_FROM_USER.getMessage()));
            }
        });
        personelList.forEach(Personel::maasHesapla);
    }
}
