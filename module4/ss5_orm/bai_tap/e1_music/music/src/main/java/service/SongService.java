package service;

import model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    private List<Song> songs=new ArrayList<>();

    public List<Song> findAll() {

    }
}
