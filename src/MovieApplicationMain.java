import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

// XML File Path (macOS): "/Users/{username}/IdeaProjects/SpringProject/src/conf/beans.xml"
// Database File Path (macOS): "/Users/{username}/IdeaProjects/SpringProject/src/res/movies.txt"
// Do not forgot to edit a database file path in <constructor-arg> in '/conf/beans.xml'

public class MovieApplicationMain {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("./conf/beans.xml");
        MovieLister ml = (MovieLister) context.getBean("movieLister");

        System.out.println("██████████████████████████████████████");
        System.out.println("██ Super Cool Movie Listing Machine ██");
        System.out.println("██████████████████████████████████████\n");

        String input;
        TabDelimitedMovieFinder tdmf = (TabDelimitedMovieFinder) context.getBean("tabDelimitedMovieFinder");
        DatabaseMovieFinder dmf = (DatabaseMovieFinder) context.getBean("DatabaseMovieFinder");

        // Finder Selection Loop
        while (true) {
            System.out.print("Choose a finder! (1 = TABDELIM, 2 = DATABASE, 0 = Quit program): ");
            Scanner sc0 = new Scanner(System.in);
            input = sc0.nextLine();

            if (input.equals("1")) {
                System.out.println("TABDELIM finder selected.");
                ml.read(tdmf);
            } else if (input.equals("2")) {
                System.out.println("DATABASE finder selected.");
                ml.read(dmf);
            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
                continue;
            }

            ml.listAllMovies();

            /*
            // Selection Loop
            while (true) {
                System.out.print("Choose an action! (0 = List all movies, 1 = Search by title, 2 = Search by director): ");
                Scanner sc = new Scanner(System.in);
                input = sc.nextLine();

                System.out.println("WARNING: If using DATABASE finder, title/director has to be exact!!");

                if (input.equals("0")) {
                    System.out.println("List all movies selected.");
                    ml.listAllMovies();
                    break;
                } else if (input.equals("1")) {
                    System.out.println("Search by title selected.");
                    System.out.print("Enter title: ");
                    Scanner sc2 = new Scanner(System.in);
                    String inptitle = sc2.nextLine();
                    ml.listByTitle(inptitle);
                    break;
                } else if (input.equals("2")) {
                    System.out.println("Search by director selected.");
                    System.out.print("Enter director: ");
                    Scanner sc2 = new Scanner(System.in);
                    String inpdirector = sc2.nextLine();
                    ml.listByDirector(inpdirector);
                    break;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }*/
        }


        System.out.println("Program Terminated");
    }
}