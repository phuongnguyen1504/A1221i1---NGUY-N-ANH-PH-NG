package vn.codegym.repository;

import vn.codegym.model.Feedback;

import java.util.List;

public interface IPictureRepository {
    List<Feedback> findAll();
    void save(Feedback student);

    void delete(int id);

    void like(int id);
}
