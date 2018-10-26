public class Movie {

    //Eigenschaften

    public int id;
    public String title;
    public int duration;
    public String description;
    public String imagePath;


    //Constructor

    public Movie(int id, String title, int duration, String description, String imagePath) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.imagePath = imagePath;
    }

}
