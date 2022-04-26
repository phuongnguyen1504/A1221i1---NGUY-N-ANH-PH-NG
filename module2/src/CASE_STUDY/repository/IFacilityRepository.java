package CASE_STUDY.repository;

import CASE_STUDY.models.Facility.Facility;

public interface IFacilityRepository {
    void displayFacility();

    void addHouse(Facility house);

    void addRoom(Facility room);

    void addVilla(Facility villa);
}
