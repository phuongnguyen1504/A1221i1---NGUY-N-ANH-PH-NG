package exam.exam.service;

import exam.exam.model.Product;
import exam.exam.repository.IProductRepository;
import exam.exam.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository= (IProductRepository) new ProductRepository();
    @Override
    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public Product selectProduct(int id) {
        return productRepository.selectProduct(id);
    }

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return productRepository.updateProduct(product);
    }

    @Override
    public List<Product> findProduct(String s) {
        return productRepository.findProduct(s);
    }

    @Override
    public List<Product> search(String key, String value) {
        return productRepository.search(key,value);
    }

    @Override
    public List<String> findListCategory() {
        return productRepository.findListCategory();
    }
}
