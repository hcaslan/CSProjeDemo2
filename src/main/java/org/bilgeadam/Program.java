package org.bilgeadam;

import org.bilgeadam.data.*;
import org.bilgeadam.util.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DosyaOku dosyaOku = new DosyaOku();
        List<Personel> personelList= dosyaOku.readFromJson();
        List<MaasBordro> maasBordroList = new ArrayList<>();

        InputHelper.getPersonelDataFromTerminal(personelList);
        personelList.forEach(Personel::maasHesapla);
        MaasBordro.createBordroList(personelList, maasBordroList);
        MaasBordro.writeBordroToJson(maasBordroList);
        MaasBordro.displayBordro(maasBordroList);
    }
}
