package bai_tap_lam_them.repository;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.model.Motobike;
import bai_tap_lam_them.model.Truck;

import java.util.List;

public interface VehicleRepository {
    void addTruck(Truck truck);

    void addCar(Car car);

    void addMotorbike(Motobike motobike);

    List<Brand> getBrand();


    List<String> getPlate(String type);
}
