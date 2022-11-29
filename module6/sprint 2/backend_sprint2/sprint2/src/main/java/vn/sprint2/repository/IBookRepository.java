package vn.sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sprint2.model.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

}
