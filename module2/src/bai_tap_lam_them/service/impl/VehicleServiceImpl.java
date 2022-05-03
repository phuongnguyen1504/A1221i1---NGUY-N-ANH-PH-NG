package bai_tap_lam_them.service.impl;

import bai_tap_lam_them.model.*;
import bai_tap_lam_them.repository.VehicleRepository;
import bai_tap_lam_them.repository.impl.VehicleRepositoryImpl;
import bai_tap_lam_them.service.VehicleService;

import java.util.List;
import java.util.Set;

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

    public Set<Brand> getBrand() {
        return vehicleRepository.getBrand();
    }



    @Override
    public Set<String> getPlate(String type) {
        return vehicleRepository.getPlate(type);
    }

    @Override
    public void displayVehicle(String vehicle) {
        vehicleRepository.displayVehicle(vehicle);
    }

    @Override
    public void delete(String plate, String vehicle) {
        vehicleRepository.delete(plate,vehicle);
    }


}
