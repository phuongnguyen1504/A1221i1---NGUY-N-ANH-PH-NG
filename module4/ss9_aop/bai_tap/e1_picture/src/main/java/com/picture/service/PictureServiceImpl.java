package com.picture.service;

import com.picture.exception.BadWordException;
import com.picture.model.Feedback;
import com.picture.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        List<String> badwords = badWordService.findListName();
        String body = song.getBody();
        String[] bodies = body.trim().split(" ");
//        https://stackoverflow.com/questions/8992100/test-if-a-string-contains-any-of-the-strings-from-an-array
        for (int i = 0; i < bodies.length; i++) {
            if (badwords.stream().anyMatch(bodies[i]::equalsIgnoreCase)) {
                throw new BadWordException("Co tu xau. Author:" + song.getAuthor() + ". Noi dung: " + song.getBody());
            }
        }
//        if(badwords.stream().anyMatch(body::contains)) {
//            throw new BadWordException("Co tu xau. Author:" + song.getAuthor() + ". Noi dung: " + song.getBody());
//        }
        song.setDate(LocalDate.now().toString());
        repository.save(song);

    }


    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void like(int id) {
        Feedback feedback = repository.findById(id).get();
        feedback.setLikeButton(feedback.getLikeButton() + 1);
        repository.save(feedback);
    }


}
