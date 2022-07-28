package vn.codegym.repository;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class PictureRepositoryImpl implements IPictureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> findAll() {
        LocalDate date=LocalDate.now();
        String str= String.valueOf(date);
        TypedQuery<Feedback> query = (TypedQuery<Feedback>) entityManager
                .createNativeQuery("SELECT * FROM feedback", Feedback.class);
        return query.getResultList();
    }

    @Override
    public void save(Feedback feedback) {
        LocalDate date=LocalDate.now();

        feedback.setDate(String.valueOf(date));
        feedback.setLike(0);
        Feedback f=feedback;
        entityManager.persist(feedback);
//        entityManager.remove(entityManager.merge(song));
//        entityManager.find(Student.class, 5); // tìm kiếm
    }
    public Feedback findById(int id){
        TypedQuery<Feedback> query= (TypedQuery<Feedback>) entityManager.createNativeQuery("SELECT * FROM feedback where id="+id, Feedback.class);
        return query.getSingleResult();
    }
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
