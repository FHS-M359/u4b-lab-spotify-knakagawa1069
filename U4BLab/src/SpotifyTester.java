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

        Scanner scan = new Scanner(System.in);

        Playlist.readInSong();
        ArrayList<Song> allSongs = Playlist.getSongs();

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

            int ans = scan.nextInt();

            if(ans == one) { //ARTIST A-Z
                playlist.ascendingSortByArtist();
            }
            else if(ans == two) { //ARTIST Z-A
                playlist.descendingSortByArtist();
            }
            else if(ans == three){ //SORT BY YEAR (OLDEST -> NEWEST)
                for (int i = 0; i < allSongs.size() - 1; i++) {
                    int minIndex = i;

                    //searches the rest of the arraylist for smallest value
                    for (int j = i + 1; j < allSongs.size(); j++) {
                        if (allSongs.get(j).getReleaseYr() < allSongs.get(minIndex).getReleaseYr()){
                            minIndex = j;
                        }
                    }

                    //swaps values
                    Song temp = allSongs.get(i);
                    allSongs.set(i, allSongs.get(minIndex));
                    allSongs.set(minIndex, temp);
                }
                for (Song a: allSongs){
                    System.out.println(a);
                }
            } //INCOMPLETE
            else if(ans == four){ //SORT BY YEAR (OLDEST -> NEWEST)
                for (int i = allSongs.size() - 1; i > 1; i--) {
                    int maxIndex = i;

                    //searches the rest of the arraylist for smallest value
                    for (int j = i - 1; j >= 0; j--) {
                        if (allSongs.get(j).getReleaseYr() < allSongs.get(maxIndex).getReleaseYr()){
                            maxIndex = j;
                        }
                    }

                    //swaps values
                    Song temp = allSongs.get(i);
                    allSongs.set(i, allSongs.get(maxIndex));
                    allSongs.set(maxIndex, temp);
                }
                for (Song a: allSongs){
                    System.out.println(a);
                }
            } //INCOMPLETE
            else if (ans == five) { //SEARCH BY GENRE
                    scan.nextLine();
                    System.out.println("Enter genre to search: ");
                    String ans2 = scan.nextLine();

                    playlist.genreSearch(ans2);
                }
            else if (ans == six) { //DISPLAY ALL SONGS
                System.out.println();
                System.out.println(String.format("%-35s %-25s %-30s %5s %15s", "Title", "Artist", "Album", "Year", "Genre"));
                System.out.println("-------------------------------------------------------------------------------------------------------------------");

                System.out.println(playlist.toString());
            }
            else if(ans == seven){ //QUIT
                cont = false;
                System.out.println("Goodbye");
            }
            System.out.println();
        }
    }
}
