package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Song;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SongRepositoryImpl implements ISongRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = (TypedQuery<Song>) entityManager
                .createNativeQuery("SELECT * FROM song", Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
//        entityManager.remove(entityManager.merge(song));
//        entityManager.find(Student.class, 5); // tìm kiếm
    }
    public Song findById(int id){
        TypedQuery<Song> query= (TypedQuery<Song>) entityManager.createNativeQuery("SELECT * FROM song where id="+id,Song.class);
        return query.getSingleResult();
    }
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
