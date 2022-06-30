package exam.exam.repository;

import exam.exam.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static final String FIND_ALL_PRODUCT = "select * from `product`";
    private static final String UPDATE_PRODUCT = "update `product` set name=?,price=?,quantity=?,color=?,category=? where id=?";
    private static final String DELETE_BY_ID = "delete from `product` where id=?";
    private static final String INSERT_PRODUCT = "insert into `product`(`name`, price, quantity,color,category) values(?,?,?,?,?)";
    private static final String SEARCH_ALL_COLUMN = "select * from `product` where name like concat('%',?,'%') or price like concat('%',?,'%') or quantity like concat('%',?,'%') or color like concat('%',?,'%') or category like concat('%',?,'%')";
    private static final String SEARCH_BY_NAME = "select * from `product` where name like concat('%',?,'%')";
    private static final String SEARCH_BY_PRICE = "select * from `product` where price like concat('%',?,'%')";
    private static final String SEARCH_BY_QUANTITY = "select * from `product` where quantity like concat('%',?,'%')";
    private static final String SEARCH_BY_COLOR = "select * from `product` where color like concat('%',?,'%')";
    private static final String SEARCH_BY_CATEGORY = "select * from `product` where category like concat('%',?,'%')";
    private final String DBURL="jdbc:mysql://localhost:3306/casestudy";
    private final String USERNAME="root";
    private final String PASSWORD="12345678";

    public ProductRepository() {
    }
    private Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    };

    @Override
    public void insertProduct(Product product) {
        try (Connection connection=getConnection();
             PreparedStatement statement=connection.prepareStatement(INSERT_PRODUCT)){
            statement.setString(1,product.getName());
            statement.setDouble(2,product.getPrice());
            statement.setInt(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Product selectProduct(int id) {
        return null;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products=new ArrayList<>();
        ResultSet rs=null;
        try(Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(FIND_ALL_PRODUCT)){
            rs=statement.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                int quantity=rs.getInt(4);
                String color=rs.getString(5);
                String description=rs.getString(6);
                String category=rs.getString(7);
                products.add(new Product(id,name,price,quantity,color,description,category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean deleteRow;
        try(Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1,id);
            deleteRow=statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteRow;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean updateRow;
        try(Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(UPDATE_PRODUCT)){
            statement.setString(1,product.getName());
            statement.setDouble(2,product.getPrice());
            statement.setInt(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getCategory());
            statement.setInt(6,product.getId());
            updateRow=statement.executeUpdate()>0;
        }
        return updateRow;
    }

    @Override
    public List<Product> findProduct(String s) {
        return null;
    }

    @Override
    public List<Product> search(String key, String value) {
        List<Product> products=new ArrayList<>();
        ResultSet rs=null;
        String query=null;
        switch (key){
            case "All":
                query= SEARCH_ALL_COLUMN;
                break;
            case "name":
                query=SEARCH_BY_NAME;
                break;
            case "price":
                query=SEARCH_BY_PRICE;
                break;
            case "quantity":
                query=SEARCH_BY_QUANTITY;
                break;
            case "color":
                query=SEARCH_BY_COLOR;
                break;
            case "category":
                query=SEARCH_BY_CATEGORY;
                break;
            default:
                return null;
        }
        try(Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(query)){
            if(key=="All") {
                statement.setString(1, value);
                statement.setString(2, value);
                statement.setString(3, value);
                statement.setString(4, value);
                statement.setString(5, value);
            }
            else {
                statement.setString(1,value);
            }

            rs=statement.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                int quantity=rs.getInt(4);
                String color=rs.getString(5);
                String description=rs.getString(6);
                String category=rs.getString(7);
                products.add(new Product(id,name,price,quantity,color,description,category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}

