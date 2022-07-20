package service;

import model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService {
    private static List<Song> songs=new ArrayList<>();
    static {
        songs.add(new Song("Aloha", "Alex", "Ballad", "link"));
        songs.add(new Song("Love", "Test 1", "Ballad", "link1"));
        songs.add(new Song("Beautiful white", "Test 2", "Ballad", "link2"));
    }
    public void create(Song song){
        songs.add(song);
    }
    public List<Song> getAll(){
        return songs;
    }
}
