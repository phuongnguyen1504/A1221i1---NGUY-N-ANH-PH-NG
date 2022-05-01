package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.model.Motobike;
import bai_tap_lam_them.model.Truck;
import bai_tap_lam_them.service.VehicleService;
import bai_tap_lam_them.service.impl.VehicleServiceImpl;

public class VehicleController {
    private static VehicleService vehicleService=new VehicleServiceImpl();
    public void addTruck(Truck truck) {
        vehicleService.addTruck(truck);
    }

    public void addCar(Car car) {
        vehicleService.addCar(car);
    }

    public void addMotorbike(Motobike motobike) {
        vehicleService.addMotorbike(motobike);
    }
}
