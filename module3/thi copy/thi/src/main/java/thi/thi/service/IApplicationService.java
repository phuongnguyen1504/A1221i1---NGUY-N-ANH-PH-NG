package thi.thi.service;

import thi.thi.model.Object;
import thi.thi.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IApplicationService {
    public boolean insertObject(Object object);
    public Object selectObject(String id);
    public List<Object> selectAllObject(int offset,
                                        int noOfRecords);
    public boolean deleteObject(String id);
    public boolean updateObject(Object object) throws SQLException;
    public List<Object> findObject(String s);

    List<Object> search(String key, String value);

    List<Category> findListCategory();

    int getNoOfRecords();

}
