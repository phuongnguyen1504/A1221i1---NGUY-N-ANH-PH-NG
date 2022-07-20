package model;

public class Song {
    private String name;
    private String artist;
    private String genre;
    private String link;

    public Song() {
    }

    public Song(String name, String artist, String genre, String link) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
