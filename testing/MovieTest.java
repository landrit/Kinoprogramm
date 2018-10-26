import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MovieTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void MovieIsNotNull(){
        Movie mov = new Movie(1,"Titel",80,"Description","Imagepath");
        Assert.assertNotNull(mov);
    }


}