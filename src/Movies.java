import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class Movies extends ArrayList<Movie> implements JSON {

    //Standardconstructor for Testing


    //Methoden

    public Movie getMovieById(int movId) {
        for (Movie mov: this) {
            if (mov.id == movId) {
                return mov;
            }
        }
        return null;
    }


    @Override
    public void saveToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);

        try {
            Writer writer = new FileWriter(Main.moviepath);
            writer.write(json);
            writer.close();
            System.out.println("Json file could be saved!");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
        }
    }


    public static Movies loadFromJson() {
        Movies movies = new Movies();
        Type collectionType = new TypeToken<Movies>(){}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Main.moviepath));
            String line;
            String json = "";
            while ((line = reader.readLine()) != null)
            {
                json += line;
            }
            reader.close();
            movies = gson.fromJson(json, collectionType);
        }
        catch (Exception ex) {
            System.out.println("Something went terrible wrong, leave the building immediately!!!");
        }
        return movies;
    }

}
