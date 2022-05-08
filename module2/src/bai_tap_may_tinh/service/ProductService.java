package bai_tap_may_tinh.service;

import java.util.List;

public interface ProductService {
    void add(String name);
    List<String> getAll(String name);

    void display();

    void delete();
}
