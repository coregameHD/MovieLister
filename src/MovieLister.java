import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieLister {
    private ArrayList<Movie> moviesList;
    private MovieFinder movieFinder;

    public void read(MovieFinder reader) {
        this.movieFinder = reader;
    }

    public void displayMovies(ArrayList<Movie> moviesList) {
        moviesList = this.movieFinder.readMoviesFile();
        for (Movie movie : moviesList){
            System.out.println("ID: " + movie.getID());
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Release Date: " + movie.getReleaseDate());
            System.out.println("Rating: " + movie.getRating());
            System.out.println();
        }
    }

    public void listAllMovies() {
        displayMovies(this.moviesList);
    }

    /*
    public void listByTitle(String title) {
        ArrayList<Movie> searchList = movieFinder.searchByTitle(title);
        displayMovies(searchList);
    }

    public void listByDirector(String director) {
        ArrayList<Movie> searchList = movieFinder.searchByDirector(director);
        displayMovies(searchList);
    }*/

    /*
    public void setMoviesList(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }
    */
}

