package thi.thi.service;

import thi.thi.model.Object;
import thi.thi.model.People;

import java.sql.SQLException;
import java.util.List;

public interface IApplicationService {
    public void insertObject(Object object);
    public Object selectObject(String id);
    public List<Object> selectAllObject();
    public boolean deleteObject(String id);
    public boolean updateObject(Object object) throws SQLException;
    public List<Object> findObject(String s);

    List<Object> search(String key, String value);

    List<People> findListCategory();


}
