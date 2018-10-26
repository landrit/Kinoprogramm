import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PersonsTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void LoadFromJson(){
        Person pers = new Person("Testperson","Passwort");
        Persons persons = new Persons();
        persons.add(pers);
        persons.loadFromJson();
    }

    @Test
    public void LoadFromJsonFail(){
        Person pers = new Person("Testperson","Passwort");
        Persons persons = new Persons();
        persons.add(pers);
        Main.personpath="testfiles/||||hallo.json";
        persons.loadFromJson();
    }

    @Test
    public void SaveToJson(){
        Person pers = new Person("Testperson","Passwort");
        Persons persons = new Persons();
        persons.add(pers);
        persons.saveToJson();
    }

    @Test
    public void SaveToJsonFail(){
        Person pers = new Person("Testperson","Passwort");
        Persons persons = new Persons();
        persons.add(pers);
        Main.personpath="testfiles/||||hallo.json";
        persons.saveToJson();
    }

}