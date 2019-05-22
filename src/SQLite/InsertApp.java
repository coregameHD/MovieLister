package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:./src/res/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String title, String director, String releaseDate, String rating) {
        String sql = "INSERT INTO movies(title, director, releasedate, rating) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, director);
            pstmt.setString(3, releaseDate);
            pstmt.setString(4, rating);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Stuart Little 2: Electric Boogaloo", "John Doe", "12/11/2016", "****");
        app.insert("Avengers Unlimited: Shrek vs. Thanos", "Adam Smith", "22/05/2017", "**");
        app.insert("Munafique", "Prabowo Shouhbianmo", "26/08/2018", "*");
        app.insert("Riddle of the Rocks", "BagleBoy", "09/11/2019", "***");
        app.insert("The Oats Movie: Complete Trilogy", "Joe Capo", "30/12/2019", "*****");
    }

}