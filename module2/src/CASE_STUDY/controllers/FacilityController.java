package CASE_STUDY.controllers;

import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.services.facility.impl.FacilityService;

public class FacilityController {
    private static FacilityService facilityService=new FacilityService();
    public void displayFacility() {
        facilityService.displayFacility();
    }



    public void addVilla(Facility villa) {
        facilityService.addVilla(villa);
    }

    public void addHouse(Facility house) {
        facilityService.addHouse(house);
    }

    public void addRoom(Facility room) {
        facilityService.addRoom(room);
    }
}
