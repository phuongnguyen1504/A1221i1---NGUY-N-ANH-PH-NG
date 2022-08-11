package com.picture.repository;

import com.picture.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPictureRepository extends JpaRepository<Feedback,Integer> {

}
