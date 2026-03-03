import org.w3c.dom.ls.LSOutput;

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

        //displays every single song (from the ArrayList)
        for(int i = 0; i < songs.size(); i++){
            output += songs.get(i).toString() + "\n";
        }

        return output;
    }

    //Method to read in Song data (void)
    public static void readInSong() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("U4BLab/spotify_unique_years_artists.txt"));

        //just makes the object
        while(scan.hasNextLine()){
            //next line (String)
            String temp = scan.nextLine();
            //break up into array (all different uses)
            String[] temp2 = temp.split(",");

            //turns the two necessary values into intergers (currently string)
            int numSeconds = Integer.parseInt(temp2[3]);
            int releaseYr = Integer.parseInt(temp2[4]);

            //creates an object, and adds to the ArrayList
            Song newSong = new Song(temp2[0], temp2[1], temp2[2], numSeconds, releaseYr, temp2[temp2.length-1]);
            songs.add(newSong);
        }
    }

    //Method to Search by and display all Songs in a specific genre (void)
    public void genreSearch(String genre){
        ArrayList<Song> genreSearch = new ArrayList<Song>();

        for (Song a : songs) { //gets all of the songs into a ArrayList
            //not case sensitive, if it matches, then add it to the later displayed String
            if (a.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                genreSearch.add(a);
            }
        }
        for (Song b : genreSearch) { //prints out all of the songs with that genre
            System.out.println(b);
        }
        if (genreSearch.size() == 0) { //if there is an empty ArrayList
            System.out.println("That does not match any genre.");
        }
    }

    //Sort by artist (Selection sort) (void) A-Z
    public void ascendingSortByArtist(){
        //temp variables for use
        String fLetter1, fLetter2;
        for (int i = 0; i < songs.size() - 1; i++) { //go through length -1 of the array
            int minIndex = i;

            //searches the rest of the arraylist for smallest value
            for (int j = i + 1; j < songs.size(); j++) { //every index after the current one being compared to
                fLetter1 = songs.get(j).getArtist().substring(0, 1);
                fLetter2 = songs.get(minIndex).getArtist().substring(0, 1);
                if (fLetter1.toLowerCase().compareTo(fLetter2.toLowerCase()) < 0){ //if this character is before the second one
                    minIndex = j;
                }
            }

            //swaps values
            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
        for (Song a: songs){
            System.out.println(a);
        }
    }

    //Sort by artist (Selection sort) (void) Z-A
    public void descendingSortByArtist(){
        String fLetter1, fLetter2;
        for (int i = songs.size() - 1; i > 1; i--) {
            int maxIndex = i;

            //searches the rest of the arraylist for smallest value
            for (int j = i - 1; j >= 0; j--) {
                fLetter1 = songs.get(j).getArtist().substring(0, 1);
                fLetter2 = songs.get(maxIndex).getArtist().substring(0, 1);
                if (fLetter1.toLowerCase().compareTo(fLetter2.toLowerCase()) < 0) {
                    maxIndex = j;
                }
            }

            //swaps values
            Song temp = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, temp);
        }
        for (Song a : songs) {
            System.out.println(a);
        }
    }

    //Sort by releaseYear (Insertion sort) (void)
    public void ascendingSortByReleaseYr(){
        //same logic used for traditional insertion sorts
        for(int i = 1; i < songs.size(); i++){ //start from 2nd index, go to end
            int tempYr = songs.get(i).getReleaseYr();
            int pos = i;

            //while the position is in the ArrayList domain, and the previous index's year is before the temp one
            while(pos > 0 && songs.get(pos - 1).getReleaseYr() > tempYr){
                songs.get(pos).setReleaseYr(songs.get(pos-1).getReleaseYr());
                pos--;
            }
            songs.get(pos).setReleaseYr(tempYr);
        }

        for (Song a : songs) {
            System.out.println(a);
        }
    }

    //Sort by releaseYear (Insertion sort) (void)
    public void descendingSortByReleaseYr(){
        for(int i = 1; i < songs.size(); i++){
            int tempYr = songs.get(i).getReleaseYr();
            int pos = i;

            while(pos > 0 && songs.get(pos - 1).getReleaseYr() < tempYr){ //you change one character for reverse logic
                songs.get(pos).setReleaseYr(songs.get(pos-1).getReleaseYr());
                pos--;
            }
            songs.get(pos).setReleaseYr(tempYr);
        }

        for (Song a : songs) {
            System.out.println(a);
        }
    }

    public static ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
