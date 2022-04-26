package CASE_STUDY.services.facility.impl;

import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.models.Facility.Villa;
import CASE_STUDY.repository.IFacilityRepository;
import CASE_STUDY.repository.impl.FacilityRepository;
import CASE_STUDY.services.facility.IFacilityService;

public class FacilityService implements IFacilityService {
    private static IFacilityRepository facilityRepository=new FacilityRepository();
    public void displayFacility() {
        facilityRepository.displayFacility();
    }

    public void addVilla(Facility Villa) {
        facilityRepository.addVilla(Villa);
    }

    public void addHouse(Facility house) {
        facilityRepository.addHouse(house);
    }

    public void addRoom(Facility room) {
        facilityRepository.addRoom(room);
    }
}
