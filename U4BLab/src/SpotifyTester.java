import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyTester {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("===== Spotify Menu ===== \n" +
                "1 - Sort by artist (A -> Z) \n" +
                "2 - Sort by artist (Z -> A) \n" +
                "3 - Sort by year (oldest -> newest) \n" +
                "4 - Sort by year (newest -> oldest) \n" +
                "5 - Search by genre \n" +
                "6 - Display all songs \n" +
                "7 - Quit \n" +
                "Enter choice (1-7)");

        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        System.out.println(String.format("%-20s %-15s %-25s %5s %15s", "Title", "Artist", "Album", "Year", "Genre"));

        if(option == 1){

        }
    }
}
