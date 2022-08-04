package com.validatesong.service;

import com.validatesong.model.Song;
import com.validatesong.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository repository;

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Song> findById(int id) {
        return repository.findById(id);
    }
}
