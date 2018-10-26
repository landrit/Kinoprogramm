import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class MoviesTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void GetMovieByIdPossible(){

        Movie mov1 = new Movie(0, "Star Wars: Rogue One", 165, "Megaaaaa geile Film imfall!!!!", "RogueOne.jpg");
        Movie mov2 = new Movie(1, "Triple X the return of Xander Cage", 115, "Vin Diesel geht auch mit 60 Jahren noch sehr gut ab...", "triplex.jpg");
        Movie mov3 = new Movie(2, "Split", 155, "James McAvoy talking to himself... the whole damn movie...", "split.jpg");
        Movie mov4 = new Movie(3, "Assasins Creed", 125,"If a game fails to impress, make it a movie that fails as well", "assassins.jpg");
        Movie mov5 = new Movie(4, "Moana", 95, "S'schweinli sooo jööööööö und de güggel isch creepy", "vaiana.jpg");
        Movie mov6 = new Movie(5, "Lala Land", 185, "la la la Liebe la la la", "lala.jpg");

        Movies movies = new Movies();
        movies.add(mov1);
        movies.add(mov2);
        movies.add(mov3);
        movies.add(mov4);
        movies.add(mov5);
        movies.add(mov6);

        movies.getMovieById(1);
        movies.getMovieById(2);
        movies.getMovieById(3);
        movies.getMovieById(4);
        movies.getMovieById(5);
        movies.getMovieById(6);

    }

    @Test
    public void GetMovieByIdNotPossible(){
        Movie mov1 = new Movie(0, "Star Wars: Rogue One", 165, "Megaaaaa geile Film imfall!!!!", "RogueOne.jpg");
        Movie mov2 = new Movie(1, "Triple X the return of Xander Cage", 115, "Vin Diesel geht auch mit 60 Jahren noch sehr gut ab...", "triplex.jpg");
        Movie mov3 = new Movie(2, "Split", 155, "James McAvoy talking to himself... the whole damn movie...", "split.jpg");
        Movie mov4 = new Movie(3, "Assasins Creed", 125,"If a game fails to impress, make it a movie that fails as well", "assassins.jpg");
        Movie mov5 = new Movie(4, "Moana", 95, "S'schweinli sooo jööööööö und de güggel isch creepy", "vaiana.jpg");
        Movie mov6 = new Movie(5, "Lala Land", 185, "la la la Liebe la la la", "lala.jpg");
        Movies movies = new Movies();
        movies.add(mov1);
        movies.add(mov2);
        movies.add(mov3);
        movies.add(mov4);
        movies.add(mov5);
        movies.add(mov6);
        movies.getMovieById(9);
    }

    @Test
    public void SaveToJson(){
        Movie mov1 = new Movie(0, "Star Wars: Rogue One", 165, "Megaaaaa geile Film imfall!!!!", "RogueOne.jpg");
        Movie mov2 = new Movie(1, "Triple X the return of Xander Cage", 115, "Vin Diesel geht auch mit 60 Jahren noch sehr gut ab...", "triplex.jpg");
        Movie mov3 = new Movie(2, "Split", 155, "James McAvoy talking to himself... the whole damn movie...", "split.jpg");
        Movie mov4 = new Movie(3, "Assasins Creed", 125,"If a game fails to impress, make it a movie that fails as well", "assassins.jpg");
        Movie mov5 = new Movie(4, "Moana", 95, "S'schweinli sooo jööööööö und de güggel isch creepy", "vaiana.jpg");
        Movie mov6 = new Movie(5, "Lala Land", 185, "la la la Liebe la la la", "lala.jpg");
        Movies movies = new Movies();
        movies.add(mov1);
        movies.add(mov2);
        movies.add(mov3);
        movies.add(mov4);
        movies.add(mov5);
        movies.add(mov6);
        movies.saveToJson();
    }

    @Test
    public void SaveToJsonFail(){
        Movie mov1 = new Movie(0, "Star Wars: Rogue One", 165, "Megaaaaa geile Film imfall!!!!", "RogueOne.jpg");

        Movies movies = new Movies();
        movies.add(mov1);
        Main.moviepath = "testfiles/||||hallo.json";
        movies.saveToJson();
        Assert.assertFalse(Main.moviepath == "testfiles/movies.json" || Main.moviepath == "testfiles/presentations.json" || Main.moviepath == "testfiles/persons.json" );

    }


    @Test
    public void LoadFromJsonPossible(){
        Movies movies = new Movies();
        movies.loadFromJson();
        Assert.assertNotNull(movies);

    }


    @Test
    public void LoadFromJsonFail(){
        Movie mov1 = new Movie(0, "Star Wars: Rogue One", 165, "Megaaaaa geile Film imfall!!!!", "RogueOne.jpg");
        Movie mov2 = new Movie(1, "Triple X the return of Xander Cage", 115, "Vin Diesel geht auch mit 60 Jahren noch sehr gut ab...", "triplex.jpg");
        Movie mov3 = new Movie(2, "Split", 155, "James McAvoy talking to himself... the whole damn movie...", "split.jpg");
        Movie mov4 = new Movie(3, "AssasinsCreed", 125,"If a game fails to impress, make it a movie that fails as well", "assasins.jpg");
        Movie mov5 = new Movie(4, "Moana", 95, "S'schweinli sooo jööööööö und de güggel isch creepy", "vaiana.jpg");
        Movie mov6 = new Movie(5, "Lala Land", 185, "la la la Liebe la la la", "lala.jpg");
        Movies movies = new Movies();
        movies.add(mov1);
        movies.add(mov2);
        movies.add(mov3);
        movies.add(mov4);
        movies.add(mov5);
        movies.add(mov6);
        Main.moviepath="testfiles/|||||hallo.json";
        movies.loadFromJson();
    }
}