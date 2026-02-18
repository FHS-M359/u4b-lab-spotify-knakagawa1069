import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyTester {
    public static void main(String[] args) throws FileNotFoundException {
        //Create constants that are equal to the int values 1-7 so that your code is more
        //readable, rather than using the values 1-7 in your if statements
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;

        Scanner scan = new Scanner(new File("U4BLab/spotify_unique_years_artists.txt"));
        Scanner scan2 = new Scanner(System.in);

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

        boolean cont = true;

        while(cont) {
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

            int ans = scan2.nextInt();

            if(ans == five){
                scan2.nextLine();
                System.out.println("Enter genre to search: ");
                String ans2 = scan2.nextLine();

                ArrayList<Song> genreSearch = new ArrayList<Song>();

                for(Song a: allSongs){
                    if(a.getGenre().toLowerCase().equals(ans2.toLowerCase())){
                        genreSearch.add(a);
                    }
                }
                System.out.println(genreSearch);
            }

            if (ans == six) {
                System.out.println();
                System.out.println(String.format("%-35s %-25s %-30s %5s %15s", "Title", "Artist", "Album", "Year", "Genre"));
                System.out.println("-------------------------------------------------------------------------------------------------------------------");

                System.out.println(playlist.toString());
            }
            else if(ans == seven){
                cont = false;
            }
        }
    }
}
