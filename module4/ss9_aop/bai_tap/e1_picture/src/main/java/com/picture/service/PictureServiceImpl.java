package com.picture.service;

import com.picture.exception.BadWordException;
import com.picture.model.Feedback;
import com.picture.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private IPictureRepository repository;
    @Autowired
    private BadWordServiceImpl badWordService;

    @Override
    public Page<Feedback> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Feedback song) throws Exception {

        List<String> badwords=badWordService.findListName();
        String body=song.getBody();
//        https://stackoverflow.com/questions/8992100/test-if-a-string-contains-any-of-the-strings-from-an-array
        if(!badwords.stream().anyMatch(body::contains)) {
            throw new BadWordException("Co tu xau. Author:" + song.getAuthor() + ". Noi dung: " + song.getBody());
        }
        repository.save(song);


    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void like(int id) {
        Feedback feedback=repository.findById(id).get();
        feedback.setLikeButton(feedback.getLikeButton()+1);
        repository.save(feedback);
    }


}
