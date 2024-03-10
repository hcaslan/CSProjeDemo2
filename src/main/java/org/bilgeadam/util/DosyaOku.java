package org.bilgeadam.util;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bilgeadam.constant.MemurLevel;
import org.bilgeadam.constant.Role;
import org.bilgeadam.data.Memur;
import org.bilgeadam.data.Personel;
import org.bilgeadam.data.Yonetici;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DosyaOku {
    public List<Personel> readFromJson() {
        List<Personel> personelList = new ArrayList<>();
        String fileName = "personals.json";
        Path filePath = findFilePath(fileName);
        if (filePath != null) {
            try {
                JsonArray jsonArray = JsonParser.parseReader(new FileReader(filePath.toString())).getAsJsonArray();

                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                    String name = jsonObject.get("name").getAsString();
                    String surname = jsonObject.get("surname").getAsString();
                    String role = jsonObject.get("role").getAsString();

                    if (role.equals(Role.MEMUR.getRole()))
                        personelList.add(new Memur(name, surname, Role.MEMUR));
                    else if (role.equals(Role.YONETICI.getRole()))
                        personelList.add(new Yonetici(name, surname, Role.YONETICI));
                }
                /*
                for (Personel personnel : personelList) {
                    System.out.println(personnel);
                }

                 */
            } catch (IOException ignored) {

            }
        }
        return personelList;
    }


    private Path findFilePath(String dosyaAdi) {
        ClassLoader classLoader = DosyaOku.class.getClassLoader();
        URL resource = classLoader.getResource(dosyaAdi);
        try {
            return Paths.get(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException ignored) {

        }catch (NullPointerException ignored){

        }
        return null;
    }

}
