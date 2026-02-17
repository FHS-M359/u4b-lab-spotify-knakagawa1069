import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyTester {
    //Create constants that are equal to the int values 1-7 so that your code is more
    //readable, rather than using the values 1-7 in your if statements
    final int one = 1;
    final int two = 2;
    final int three = 3;
    final int four = 4;
    final int five = 5;
    final int six = 6;
    final int seven = 7;

    public static void main(String[] args) throws FileNotFoundException {
        //Show menu of choices and user selects a choice to sort by Artist A-Z, Z-A, sort
        //by releaseYear old-new or new-old, search by genre, or quit.
        System.out.println("===== Spotify Menu ===== \n" +
                "1 - Sort by artist (A -> Z) \n" +
                "2 - Sort by artist (Z -> A) \n" +
                "3 - Sort by year (oldest -> newest) \n" +
                "4 - Sort by year (newest -> oldest) \n" +
                "5 - Search by genre \n" +
                "6 - Display all songs \n" +
                "7 - Quit \n" +
                "Enter choice (1-7)");

        Scanner scan = new Scanner(new File("U4BLab/spotify_unique_years_artists.txt"));

        //Arraylist of song object
        ArrayList<Song> allSongs = new ArrayList<Song>();

        //just makes the object
        while(scan.hasNextLine()){
            String temp = scan.nextLine();
            String[] temp2 = temp.split(",");

            int numSeconds = Integer.parseInt(temp2[3]);
            int releaseYr = Integer.parseInt(temp2[4]);

            Song newSong = new Song(temp2[0], temp2[1], temp2[2], numSeconds, releaseYr, temp2[temp2.length-1]);
            allSongs.add(newSong);
        }

        //object of playlist
        Playlist playlist = new Playlist(allSongs);

        int option = scan.nextInt();
        System.out.println(String.format("%-20s %-15s %-25s %5s %15s", "Title", "Artist", "Album", "Year", "Genre"));

        System.out.println(playlist.toString());
    }
}
