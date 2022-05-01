package bai_tap_lam_them.service.impl;

import bai_tap_lam_them.model.*;
import bai_tap_lam_them.repository.VehicleRepository;
import bai_tap_lam_them.repository.impl.VehicleRepositoryImpl;
import bai_tap_lam_them.service.VehicleService;

import java.util.ArrayList;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private static VehicleRepository vehicleRepository = new VehicleRepositoryImpl();

    @Override
    public void addTruck(Truck truck) {
        vehicleRepository.addTruck(truck);
    }

    @Override
    public void addCar(Car car) {
        vehicleRepository.addCar(car);
    }

    @Override
    public void addMotorbike(Motobike motobike) {
        vehicleRepository.addMotorbike(motobike);
    }

    public List<Brand> getBrand() {
        return vehicleRepository.getBrand();
    }

    @Override
    public List<String> getPlate() {
        return null;
    }


    @Override
    public List<String> getPlate(String type) {
        return vehicleRepository.getPlate(type);
    }


}
