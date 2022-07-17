package thi.thi.service;

import thi.thi.model.Category;
import thi.thi.model.Object;
import thi.thi.repository.ApplicationRepository;
import thi.thi.repository.IApplicationRepository;

import java.sql.SQLException;
import java.util.List;

public class ApplicationService implements IApplicationService{
    private IApplicationRepository applicationRepository=new ApplicationRepository();
    @Override
    public boolean insertObject(Object object) {
        return applicationRepository.insertObject(object);
    }

    @Override
    public Object selectObject(String id) {
        return applicationRepository.selectObject(id);
    }

    @Override
    public List<Object> selectAllObject(int offset,
                                        int noOfRecords) {
        return applicationRepository.selectAllObject(offset,noOfRecords);
    }

    @Override
    public boolean deleteObject(String id) {
        return applicationRepository.deleteObject(id);
    }

    @Override
    public boolean updateObject(Object object) throws SQLException {
        return applicationRepository.updateObject(object);
    }

    @Override
    public List<Object> findObject(String s) {
        return applicationRepository.findObject(s);
    }

    @Override
    public List<Object> search(String key, String value) {
        return applicationRepository.search(key,value);
    }

    @Override
    public List<Category> findListCategory() {
        return applicationRepository.findListCategory();
    }

    @Override
    public int getNoOfRecords() {
        return applicationRepository.getNoOfRecords();
    }


}
