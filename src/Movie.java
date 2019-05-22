public class Movie {
    private int id;
    private String title;
    private String director;
    private String releaseDate;
    private String rating;

    public Movie(int id, String title, String director, String releaseDate, String rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating.replace("*", "⭐️");
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }
}