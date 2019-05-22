import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TabDelimitedMovieFinder implements MovieFinder {
    public ArrayList<Movie> moviesList;
    public String inputFile;

    public TabDelimitedMovieFinder(String inputFile){
        this.moviesList = new ArrayList<>();
        this.inputFile = inputFile;
    }

    @Override
    public ArrayList<Movie> readMoviesFile() {
        Path inputPath = Paths.get(this.inputFile);
        System.out.println("Reading File...\n");

        try (Scanner scanner = new Scanner(inputPath)) {
            String movieID;
            String movieTitle;
            String movieDirector;
            String movieReleaseDate;
            String movieRating;
            String line;
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line,"\t"); // Use `tab` as a text delimiter
                movieID = tokenizer.nextToken();
                movieTitle = tokenizer.nextToken();
                movieDirector = tokenizer.nextToken();
                movieReleaseDate = tokenizer.nextToken();
                movieRating = tokenizer.nextToken();
                this.moviesList.add(new Movie(Integer.parseInt(movieID), movieTitle, movieDirector, movieReleaseDate, movieRating));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }

        return this.moviesList;
    }

    /*
    @Override
    public ArrayList<Movie> searchByTitle(String title) {
        ArrayList<Movie> searchList = new ArrayList<>();
        for (Movie movie : this.moviesList) {
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())) {
                searchList.add(movie);
            }
        }
        return searchList;
    }

    @Override
    public ArrayList<Movie> searchByDirector(String director) {
        ArrayList<Movie> searchList = new ArrayList<>();
        for (Movie movie : this.moviesList) {
            if (movie.getDirector().toUpperCase().contains(director.toUpperCase())) {
                searchList.add(movie);
            }
        }
        return searchList;
    }*/

}