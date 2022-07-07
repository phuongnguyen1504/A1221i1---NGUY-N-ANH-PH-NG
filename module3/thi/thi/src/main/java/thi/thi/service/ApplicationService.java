package thi.thi.service;

import thi.thi.model.Object;
import thi.thi.model.People;
import thi.thi.repository.ApplicationRepository;
import thi.thi.repository.IApplicationRepository;

import java.sql.SQLException;
import java.util.List;

public class ApplicationService implements IApplicationService{
    private IApplicationRepository applicationRepository=new ApplicationRepository();
    @Override
    public void insertObject(Object object) {
        applicationRepository.insertObject(object);
    }

    @Override
    public Object selectObject(String id) {
        return applicationRepository.selectObject(id);
    }

    @Override
    public List<Object> selectAllObject() {
        return applicationRepository.selectAllObject();
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
    public List<People> findListCategory() {
        return applicationRepository.findListCategory();
    }
}
