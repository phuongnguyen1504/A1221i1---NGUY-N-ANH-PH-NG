package thi.thi.repository;

import thi.thi.model.Object;
import thi.thi.model.Category;

import java.util.List;

public interface IApplicationRepository {
    boolean insertObject(Object object);

    Object selectObject(String id);

    List<Object> selectAllObject(int offset,
                                 int noOfRecords);

    boolean deleteObject(String id);

    boolean updateObject(Object object);

    List<Object> findObject(String s);

    List<Object> search(String key, String value);

    List<Category> findListCategory();
    int getNoOfRecords();
}
