package thi.thi.repository;

import thi.thi.model.Object;
import thi.thi.model.People;

import java.util.List;

public interface IApplicationRepository {
    void insertObject(Object object);

    Object selectObject(String id);

    List<Object> selectAllObject();

    boolean deleteObject(String id);

    boolean updateObject(Object object);

    List<Object> findObject(String s);

    List<Object> search(String key, String value);

    List<People> findListCategory();
}
