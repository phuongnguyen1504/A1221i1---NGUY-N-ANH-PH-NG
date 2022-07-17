package exam.exam.repository;

import exam.exam.model.Category;
import exam.exam.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    public void insertProduct(Product product);
    public Product selectProduct(int id);
    public List<Product> selectAllProduct(int offset,
                                          int noOfRecords);
    public boolean deleteProduct(int id);
    public boolean updateProduct(Product product) throws SQLException;
    public List<Product> findProduct(String s);

    List<Product> search(String key, String value);

    List<Category> findListCategory();

    int getNoOfRecords();
}
