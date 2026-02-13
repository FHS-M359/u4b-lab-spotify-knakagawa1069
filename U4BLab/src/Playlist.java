import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Playlist(ArrayList<Song> songs){
        this.songs = songs;
    }

    public String toString(){
        String output = "";

        for(Song a: songs){
            output += a.toString();
        }

        return output;
    }

    public static void readInSong() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("spotify_unique_years_artists.txt"));

        while(scan.hasNextLine()){
            String temp = scan.nextLine();
            String[] temp2 = temp.split(",");

            int numSeconds = Integer.parseInt(temp2[3]);
            int releaseYr = Integer.parseInt(temp2[4]);

            Song newSong = new Song(temp2[0], temp2[1], temp2[2], numSeconds, releaseYr, temp2[temp2.length-1]);
            songs.add(newSong);
        }
    }

    public void genreSearch(){

    }

    public void sortByArtist(){

    }

    public void sortByReleaseYr(){

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
