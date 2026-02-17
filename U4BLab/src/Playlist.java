import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private static ArrayList<Song> songs = new ArrayList<Song>();

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

    //Method to read in Song data (void)
    public static void readInSong(){

    }

    //Method to Search by and display all Songs in a specific genre (void)
    public void genreSearch(){

    }

    //Sort by artist (Selection sort) (void)
    public void sortByArtist(){

    }

    //Sort by releaseYear (Insertion sort) (void)
    public void sortByReleaseYr(){

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
