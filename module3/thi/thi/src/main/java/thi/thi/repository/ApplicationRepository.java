package thi.thi.repository;

import thi.thi.model.Object;
import thi.thi.model.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository implements IApplicationRepository{
    private static final String SELECT_ALL_OBJECT = "select * from `benh_an` ba join `benh_nhan` bn on ba.id_benh_nhan=bn.id;";
    private static final String INSERT_OBJECT = "insert into `benh_an`(`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES (?,?,?,?,?);";
    private static final String DELETE_OBJECT = "delete from `benh_an` where id=?;";
    private static final String UPDATE_OBJECT = "update `benh_an` set date_in=?,date_out=?,reason=?,id_benh_nhan=? where id=?;";
    private static final String FIND_LIST_PEOPLE = "SELECT * from `benh_nhan`";
    private DBConnection dbConnection=new DBConnection();

    public ApplicationRepository() {
    }

    @Override
    public void insertObject(Object object) {
        try (Connection connection=DBConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(INSERT_OBJECT)){
            statement.setString(1,object.getId_object());
            statement.setString(2,object.getDate_in());
            statement.setString(3,object.getDate_out());
            statement.setString(4,object.getReason());
            statement.setString(5,object.getId_patience());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object selectObject(String id) {
        return null;
    }

    @Override
    public List<Object> selectAllObject() {
        List<Object> list=new ArrayList<>();
        ResultSet rs=null;
        try(Connection connection=DBConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(SELECT_ALL_OBJECT)) {
            rs=statement.executeQuery();
            while (rs.next()){
                String id_ba=rs.getString(1);
                String date_in=rs.getString(2);
                String date_out=rs.getString(3);
                String reason=rs.getString(4);
                String id_bn=rs.getString(5);
                String name=rs.getString(7);
                list.add(new Object(id_ba,id_bn,name,date_in,date_out,reason));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean deleteObject(String id) {
        boolean deleteRow;
        try(Connection connection=DBConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE_OBJECT)) {
            statement.setString(1,id);
            deleteRow=statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteRow;
    }

    @Override
    public boolean updateObject(Object object) {
        boolean updateRow;
        try(Connection connection=DBConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(UPDATE_OBJECT)) {
            statement.setString(1,object.getDate_in());
            statement.setString(2,object.getDate_out());
            statement.setString(3,object.getReason());
            statement.setString(4,object.getName_patience());
            statement.setString(5,object.getId_object());
            updateRow=statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateRow;
    }

    @Override
    public List<Object> findObject(String s) {
        return null;
    }

    @Override
    public List<Object> search(String key, String value) {
        return null;
    }

    @Override
    public List<People> findListCategory() {
        List<People> people=new ArrayList<>();
        ResultSet rs=null;

        try(Connection connection=DBConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_LIST_PEOPLE)) {
            rs=statement.executeQuery();
            while (rs.next()){
                String id=rs.getString(1);
                String name=rs.getString(2);
                people.add(new People(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }
}
