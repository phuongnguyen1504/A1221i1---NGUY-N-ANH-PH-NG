package FuramaCaseStudy.service;

import java.util.List;

public interface BaseService <T>{
    void save(T t);
    List<T> getAll();
}
