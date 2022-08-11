package com.picture.repository;

import com.picture.model.BadWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadWordRepository extends JpaRepository<BadWord,Integer> {
    @Query(value = "select val from badword",nativeQuery = true)
    List<String> findListName();
}
