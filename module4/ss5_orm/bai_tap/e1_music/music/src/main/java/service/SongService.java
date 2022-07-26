package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    private List<Song> songs=new ArrayList<>();
    @PersistenceContext
    private EntityManager entityManager;

    public List<Song> findAll() {
        TypedQuery<Song> query = entityManager
                .createQuery("SELECT s FROM Song as s", Song.class);
        return query.getResultList();
    }
}
