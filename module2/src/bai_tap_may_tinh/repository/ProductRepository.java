package bai_tap_may_tinh.repository;

import bai_tap_may_tinh.model.Authentic;

import java.util.List;

public interface ProductRepository {

    List<String> getAll(String name);


    void add(String value, String PATH);

    void displayProduct();

    void delete(String id, String chinhhang);
}
