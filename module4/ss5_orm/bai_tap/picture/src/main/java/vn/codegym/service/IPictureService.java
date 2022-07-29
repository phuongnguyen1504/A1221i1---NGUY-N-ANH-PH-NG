package vn.codegym.service;

import vn.codegym.model.Feedback;

import java.util.List;

public interface IPictureService {
    List<Feedback> findAll();


    void save(Feedback song);

    void delete(int id);

    void like(int id);
}
