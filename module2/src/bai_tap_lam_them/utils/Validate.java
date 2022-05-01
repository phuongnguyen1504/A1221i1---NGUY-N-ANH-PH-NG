package bai_tap_lam_them.utils;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.service.VehicleService;
import bai_tap_lam_them.service.impl.VehicleServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Validate {
    private static VehicleService vehicleService=new VehicleServiceImpl();
    public static boolean isExistsBrand(String brand){
        return vehicleService.getBrand().stream().anyMatch(e->e.getName().equals(brand));
    }
    public static  void displayExistBrand(){
        List<Brand> li= vehicleService.getBrand();
        for (Brand brand:li){
            System.out.print(brand.getName()+"\t");
        }
    }
    public static boolean isExistsPlate(String plate,String type){
       return vehicleService.getPlate(type).stream().anyMatch(e->e.equals(plate));
    }
}
