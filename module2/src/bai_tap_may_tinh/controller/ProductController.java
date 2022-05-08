package bai_tap_may_tinh.controller;

import bai_tap_may_tinh.service.ProductService;
import bai_tap_may_tinh.service.impl.ProductServiceImpl;

public class ProductController {
    private static ProductService productService=new ProductServiceImpl();

    public void add(String name) {
        productService.add(name);
    }

    public void display() {
        productService.display();
    }

    public void delete() {
        productService.delete();
    }
}
