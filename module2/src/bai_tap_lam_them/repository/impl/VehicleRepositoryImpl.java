package bai_tap_lam_them.repository.impl;

import CASE_STUDY.models.Person.Customer;
import bai_tap_lam_them.model.*;
import bai_tap_lam_them.repository.VehicleRepository;
import bai_tap_lam_them.service.VehicleService;
import bai_tap_lam_them.utils.ConstantUtils;
import bai_tap_lam_them.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class VehicleRepositoryImpl implements VehicleRepository {
    private static ReadAndWrite readAndWrite = new ReadAndWrite();
    private static Set<Brand> listBrand = new LinkedHashSet<>();
    private static Set<String> listPlate = new LinkedHashSet<>();

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

    public Set<Brand> getBrand() {
        Set<String> stringList = readAndWrite.ReadFile(ConstantUtils.PATH.BRAND);
        listBrand = new LinkedHashSet<>();
        for (String str : stringList) {
            String[] temp = str.split(",");
            listBrand.add(new Brand(temp[0], temp[1], temp[2]));
        }
        return listBrand;
    }


    public Set<String> getPlate(String name) {

        Set<String> stringList = readAndWrite.ReadFile(ConstantUtils.PATH.setPath(name));
        listPlate = new LinkedHashSet<>();
        for (String str : stringList) {
            String[] temp = str.split(",");
            listPlate.add(temp[0]);
        }
        return listPlate;
    }

    @Override
    public void displayVehicle(String vehicle) {
        Set<String> stringList = readAndWrite.ReadFile(ConstantUtils.PATH.setPath(vehicle));
        if (vehicle.equals("TRUCK")){
            displayTruck(stringList);
        }
        else if(vehicle.equals("CAR")){
            displayCar(stringList);
        }
        else {
            displayMoto(stringList);
        }
    }

    @Override
    public void delete(String plate, String vehicle) {
        Set<String> stringList = readAndWrite.ReadFile(ConstantUtils.PATH.setPath(vehicle));
        Set<String> setWrite=new LinkedHashSet<>();
        for (String li:stringList){
            String[] temp=li.split(",");
            if (!plate.equals(temp[0])){
                setWrite.add(li);
            }
        }
        readAndWrite.writeFile(setWrite,ConstantUtils.PATH.setPath(vehicle));
        System.out.println("Đã xóa phương tiện");
    }

    private void displayMoto(Set<String> stringList) {
        int i=1;
        System.out.printf("%-7s%-15s%-15s%-12s%-20s%s", "STT","Biển kiểm soát","Hãng SX","Năm SX","Chủ sở hữu","Công suất\n");
        for (String li : stringList) {
            String[] temp=li.split(",");
            System.out.printf("");
            System.out.printf("%-7s%-15s%-15s%-12s%-20s%s", (i),temp[0],temp[1],temp[2],temp[3],temp[4]);
            System.out.println();
            i++;
        }
    }

    private void displayCar(Set<String> stringList) {
        int i=1;
        System.out.printf("%-7s%-15s%-15s%-12s%-12s%-20s%s", "STT","Biển kiểm soát","Hãng SX","Năm SX","Kiểu xe","Chủ sở hữu","Số chổ ngồi\n");
        for (String li : stringList) {
            String[] temp=li.split(",");
            System.out.printf("");
            System.out.printf("%-7s%-15s%-15s%-12s%-12s%-20s%s", (i),temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
            System.out.println();
            i++;
        }
    }

    public void displayTruck(Set<String> list){
        int i=1;
        System.out.printf("%-7s%-15s%-15s%-12s%-20s%s", "STT","Biển kiểm soát","Hãng SX","Năm SX","Chủ sở hữu","Tải trọng\n");
        for (String li : list) {
            String[] temp=li.split(",");
            System.out.printf("");
            System.out.printf("%-7s%-15s%-15s%-12s%-20s%s", (i),temp[0],temp[1],temp[2],temp[3],temp[4]);
            System.out.println();
            i++;
        }
    }
}
