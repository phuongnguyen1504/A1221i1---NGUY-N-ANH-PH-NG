package bai_tap_lam_them.repository.impl;

import bai_tap_lam_them.model.*;
import bai_tap_lam_them.repository.VehicleRepository;
import bai_tap_lam_them.service.VehicleService;
import bai_tap_lam_them.utils.ConstantUtils;
import bai_tap_lam_them.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private static ReadAndWrite readAndWrite = new ReadAndWrite();
    private static List<Brand> listBrand = new ArrayList<>();
    private static List<String> listPlate = new ArrayList<>();

    @Override
    public void addTruck(Truck truck) {
        readAndWrite.WriteFile(truck.toString(), ConstantUtils.PATH.TRUCK, true);
        System.out.println("Đã thêm xe tải");
    }


    @Override
    public void addCar(Car car) {
        readAndWrite.WriteFile(car.toString(), ConstantUtils.PATH.CAR, true);
        System.out.println("Đã thêm ô tô");

    }

    @Override
    public void addMotorbike(Motobike motobike) {
        readAndWrite.WriteFile(motobike.toString(), ConstantUtils.PATH.MOTORBIKE, true);
        System.out.println("Đã thêm xe máy");
    }

    public List<Brand> getBrand() {
        List<String> stringList = readAndWrite.ReadFile(ConstantUtils.PATH.BRAND);
        listBrand = new ArrayList<>();
        for (String str : stringList) {
            String[] temp = str.split(",");
            listBrand.add(new Brand(temp[0], temp[1], temp[2]));
        }
        return listBrand;
    }


    public List<String> getPlate(String name) {

        List<String> stringList = readAndWrite.ReadFile(ConstantUtils.PATH.setPath(name));
        listPlate = new ArrayList<>();
        for (String str : stringList) {
            String[] temp = str.split(",");
            listPlate.add(temp[0]);
        }
        return listPlate;
    }
}
