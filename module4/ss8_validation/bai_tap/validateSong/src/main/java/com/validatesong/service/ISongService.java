package com.validatesong.service;


import com.validatesong.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();


    void save(Song song);

    void delete(int id);

    Optional<Song> findById(int id);
}
