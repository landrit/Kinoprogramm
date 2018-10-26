import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class Persons extends ArrayList<Person> implements JSON {

    //Methoden

    public Persons loadFromJson() {
        Persons persons = new Persons();
        Type collectionType = new TypeToken<Persons>(){}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Main.personpath));
            String line;
            String json = "";
            while ((line = reader.readLine()) != null)
            {
                json += line;
            }
            reader.close();
            persons = gson.fromJson(json, collectionType);
        }
        catch (Exception ex) {
            System.out.println("Something went terrible wrong, leave the building immediately!!!");
            System.out.println(ex);
        }
        return persons;
    }



    @Override
    public void saveToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);

        try {
            Writer writer = new FileWriter(Main.personpath);
            writer.write(json);
            writer.close();
            System.out.println("Json file could be saved!");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
        }
    }
}
