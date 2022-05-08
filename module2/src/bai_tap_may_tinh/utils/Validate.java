package bai_tap_may_tinh.utils;

import bai_tap_may_tinh.service.ProductService;
import bai_tap_may_tinh.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Set;

public class Validate {
    private static ProductService productService=new ProductServiceImpl();
    public static int getSize(String name){
       List<String> setlist=productService.getAll(name);
        return Integer.parseInt(setlist.get(setlist.size()-1).split(",")[0]);
    }
    public static boolean isExistsId(String id,String PATH){
        return productService.getAll(PATH).stream().anyMatch(e->e.split(",")[0].equals(id));
    }
}
