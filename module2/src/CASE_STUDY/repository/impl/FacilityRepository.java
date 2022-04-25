package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.repository.IFacilityRepository;

import java.util.*;

public class FacilityRepository implements IFacilityRepository {
    private static int tempOfVilla;
    private static int tempOfHouse;
    private static int tempOfRoom;
    private static LinkedHashMap<String, Integer> facilityvalueMap=new LinkedHashMap<String,Integer>();
    private static List<Facility> listFacility=new ArrayList<>();

    public static void displayBooking() {
        System.out.println("Danh sách các phòng:");
        for (String key : facilityvalueMap.keySet()) {
            int value = facilityvalueMap.get(key);
            System.out.println(key + " = " + value);
        }
    }

    @Override
    public void displayFacility() {
        /*for (Map.Entry<String, Integer> entry : facilityvalueMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
        System.out.println("Danh sách hiển thị");
        for (Facility facility : listFacility) {
            System.out.println(facility);
        }
    }

    @Override
    public void addVilla(int numberOfVilla) {
        for (int i=0;i<=facilityvalueMap.size();i++){
            String c= "Villa";
            if (!facilityvalueMap.containsKey(c)){
                facilityvalueMap.put(c,numberOfVilla);
                tempOfVilla=numberOfVilla;
            }
            else {
                facilityvalueMap.replace(c,(tempOfVilla+numberOfVilla));
                tempOfVilla+=numberOfVilla;
            }
            break;
        }
        System.out.println("Đã thêm Villa vào database");
    }

    @Override
    public void addHouse(int house) {
        for (int i=0;i<=facilityvalueMap.size();i++){
            String c="House";
            if(!facilityvalueMap.containsKey(c)){
                facilityvalueMap.put(c,house);
                tempOfHouse=house;
            }
            else {
                facilityvalueMap.replace(c,(tempOfHouse+house));
                tempOfHouse+=house;
            }
            break;
        }
        System.out.println("Đã thêm House vào database");
    }

    @Override
    public void addRoom(int room) {
        for (int i=0;i<=facilityvalueMap.size();i++){
            String c="Room";
            if(!facilityvalueMap.containsKey(c)){
                facilityvalueMap.put(c,room);
                tempOfRoom=room;
            }
            else {
                facilityvalueMap.replace(c,(tempOfRoom+room));
                tempOfRoom+=room;
            }
            break;
        }
        System.out.println("Đã thêm Room vào database");
    }
}
