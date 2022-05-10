package FuramaCaseStudy.util;

public interface ConstantUtil {
    enum RentType {
        DAY,
        MONTH,
        YEAR
    }

    enum RoomType {
        STANDARD,
        SUPERIOR,
        DELUXE,
        SUITE,
        PRESIDENTIAL
    }

    enum TypeCustomer{
        DIAMOND,
        PLATINIUM,
        GOLC,
        SILVER,
        MEMBER
    }

    enum Degree{
        INTERMEDIATE,
        ASSOCIATE,
        BACHERLOR,
        MASTER,
        DOCTER,
        PROFESSOR
    }

    enum Position{
        Receptionist,
        ATTENDANT,
        SUPERVISOR,
        SECURITY,
        HR,
        SALES,
        DIRECTOR,
        CHEF,
        MANAGER
    }

    enum Gender{
        MALE,
        FEMALE,
        UNKNOW
    }

    interface PATH{
        String EMPLOYEE= "src/FuramaCaseStudy/data/employee.csv";
        String CUSTOMER= "src/FuramaCaseStudy/data/customer.csv";
        String VILLA= "src/FuramaCaseStudy/data/villa.csv";
        String HOUSE= "src/FuramaCaseStudy/data/house.csv";
        String ROOM= "src/FuramaCaseStudy/data/room.csv";
        String BOOKING= "src/FuramaCaseStudy/data/booking.csv";
        String CONTRACT= "src/FuramaCaseStudy/data/contract.csv";
    }
}
