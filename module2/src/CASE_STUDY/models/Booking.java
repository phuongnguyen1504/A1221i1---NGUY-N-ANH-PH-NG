package CASE_STUDY.models;

import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.models.Person.Customer;

public class Booking {
    private String bookingCode;
    private String bookingStart;
    private String bookingEnd;
    private String CustomerCode;
    private String nameOfService;
    private String typeOfService;

    public Booking() {
    }

    public Booking(String bookingCode, String bookingStart, String bookingEnd,
                   String customerCode, String nameOfService, String typeOfService) {
        this.bookingCode = bookingCode;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        CustomerCode = customerCode;
        this.nameOfService = nameOfService;
        this.typeOfService = typeOfService;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(String bookingStart) {
        this.bookingStart = bookingStart;
    }

    public String getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(String bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }
}
