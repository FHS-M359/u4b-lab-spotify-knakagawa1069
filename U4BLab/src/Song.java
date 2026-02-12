public class Song {
    private String title, artist, album, genre;
    private int releaseYr, numSeconds;

    public Song(String title, String artist, String album, int numSeconds, int releaseYr, String genre){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.numSeconds = numSeconds;
        this.releaseYr = releaseYr;
        this.genre = genre;
    }

    public String toString() {
        return (String.format("%-20s %-15s %-25s %5d %15d");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYr() {
        return releaseYr;
    }

    public void setReleaseYr(int releaseYr) {
        this.releaseYr = releaseYr;
    }

    public int getNumSeconds() {
        return numSeconds;
    }

    public void setNumSeconds(int numSeconds) {
        this.numSeconds = numSeconds;
    }
}
