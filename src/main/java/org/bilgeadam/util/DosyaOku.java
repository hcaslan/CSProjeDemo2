package org.bilgeadam.util;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bilgeadam.constant.*;
import org.bilgeadam.data.*;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class DosyaOku {
    public List<Personel> readFromJson() {
        List<Personel> personelList = new ArrayList<>();
        String fileName = "personels.json";
        Path filePath = Generator.createFilePath(fileName);
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
            } catch (IOException e) {
                OutputHelper.errorMessage((OutputMessage.ERROR.getMessage() + e.getCause()));
            }
        }
        return personelList;
    }
}
