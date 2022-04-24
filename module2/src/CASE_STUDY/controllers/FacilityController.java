package CASE_STUDY.controllers;

import CASE_STUDY.services.facility.impl.FacilityService;

public class FacilityController {
    private static FacilityService facilityService=new FacilityService();
    public void displayFacility() {
        facilityService.displayFacility();
    }

    public void addVilla(int numberOfVilla) {
        facilityService.addVilla(numberOfVilla);
    }

    public void addHouse(int house) {
        facilityService.addHouse(house);
    }

    public void addRoom(int room) {
        facilityService.addRoom(room);
    }
}
