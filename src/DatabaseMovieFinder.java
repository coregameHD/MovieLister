import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMovieFinder implements MovieFinder {
    public String inputFile;
    public ArrayList<Movie> moviesList;

    public DatabaseMovieFinder(String inputFile){
        this.inputFile = inputFile;
        this.moviesList = new ArrayList<>();
    }

    @Override
    public ArrayList<Movie> readMoviesFile() {
        System.out.println("Reading from Database...\n");

        String sql = "SELECT id, title, director, releasedate, rating FROM movies";

        try (Connection conn = this.connect(inputFile);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // populate moviesList
            while (rs.next()) {
                this.moviesList.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getString("releasedate"), rs.getString("rating")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return this.moviesList;
    }

    /*
    @Override
    public ArrayList<Movie> searchByTitle(String title) {
        ArrayList<Movie> moviesList = new ArrayList<>();

        System.out.println("Searching through the Database...\n");

        String sql = "SELECT id, title, director, releasedate, rating FROM movies WHERE title = " + title;

        try (Connection conn = this.connect(inputFile);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // populate moviesList
            while (rs.next()) {
                moviesList.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getString("releasedate"), rs.getString("rating")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return moviesList;
    }

    @Override
    public ArrayList<Movie> searchByDirector(String director) {
        ArrayList<Movie> moviesList = new ArrayList<>();

        System.out.println("Searching through the Database...\n");

        String sql = "SELECT id, title, director, releasedate, rating FROM movies WHERE director = " + director;

        try (Connection conn = this.connect(inputFile);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // populate moviesList
            while (rs.next()) {
                moviesList.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getString("releasedate"), rs.getString("rating")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return moviesList;
    }*/

    private Connection connect(String inputFile) {
        // SQLite connection string
        String url = "jdbc:sqlite:" + inputFile;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error reading database: " + e);
        }
        return conn;
    }

}