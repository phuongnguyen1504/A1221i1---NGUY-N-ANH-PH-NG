package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Feedback;
import vn.codegym.repository.IPictureRepository;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private IPictureRepository repository;

    @Override
    public List<Feedback> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Feedback song) {
        repository.save(song);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void like(int id) {
        repository.like(id);
    }
}
