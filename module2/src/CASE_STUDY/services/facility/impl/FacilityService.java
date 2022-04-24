package CASE_STUDY.services.facility.impl;

import CASE_STUDY.repository.IFacilityRepository;
import CASE_STUDY.repository.impl.FacilityRepository;
import CASE_STUDY.services.facility.IFacilityService;

public class FacilityService implements IFacilityService {
    private static IFacilityRepository facilityRepository=new FacilityRepository();
    public void displayFacility() {
        facilityRepository.displayFacility();
    }

    public void addVilla(int numberOfVilla) {
        facilityRepository.addVilla(numberOfVilla);
    }

    public void addHouse(int house) {
        facilityRepository.addHouse(house);
    }

    public void addRoom(int room) {
        facilityRepository.addRoom(room);
    }
}
