package bai_tap_lam_them.utils;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.service.VehicleService;
import bai_tap_lam_them.service.impl.VehicleServiceImpl;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validate {
    private static VehicleService vehicleService = new VehicleServiceImpl();

    public static boolean isExistsBrand(String brand) {
        return vehicleService.getBrand().stream().anyMatch(e -> e.getName().equals(brand));
    }

    public static void displayExistBrand() {
        Set<Brand> li = vehicleService.getBrand();
        for (Brand brand : li) {
            System.out.print(brand.getName() + "\t");
        }
    }

    public static boolean isExistsPlate(String plate, String type) {
        return vehicleService.getPlate(type).stream().anyMatch(e -> e.equals(plate));
    }

    public static boolean validatePlate(String plate, String type, String typeOfCar) {
        Pattern pattern;
        switch (type) {
            case "TRUCK":
                //43C-45.235: \\d{2}C-\\d{2}.\\d{3}$ ||  ^\d{2}[C][-]\d\d[.]\d\d\d$
                pattern = Pattern.compile("^\\d{2}C-\\d{2}.\\d{3}$");
                if (pattern.matcher(plate).matches()) {
                    return true;
                }
                break;
            case "CAR":
                //43A-212.56 ^\\d{2}A-\\d{3}.\\d{2}$ || ^\d{2}[A][-]\d\d\d[.]\d\d$
                if (typeOfCar.equals("Du lịch")) {
                    pattern = Pattern.compile("^\\d{2}A-\\d{3}.\\d{2}$");
                    if (pattern.matcher(plate).matches()) {
                        return true;
                }
                    //43B-453.89 ^\\d{2}B-\\d{3}.\\d{2}$ || ^\d{2}[B][-]\d\d\d[.]\d\d$
                } else if (typeOfCar.equals("Xe khách")){
                    pattern = Pattern.compile("^\\d{2}B-\\d{3}.\\d{2}$");
                    if (pattern.matcher(plate).matches()) {
                        return true;
                    }
                }
                break;
            case "MOTORBIKE":
                //43-K1-678.56 ^\\d{2}-\\w(\\w|\\d)-\\d{3}.\\d{2}$ || ^\d{2}[-][A-Z][0-9A-Z][-]\d\d\d[.]\d\d$
                pattern = Pattern.compile("^\\d{2}-\\w((\\w)|(\\d))-\\d{3}.\\d{2}$");
                if (pattern.matcher(plate).matches()) {
                    return true;
                }
                break;
        }
        return false;
    }
    public static boolean isExistsYear(String year){
        Pattern pattern;
        pattern=Pattern.compile("\\d{4}");
        if (pattern.matcher(year).matches()){
            return true;
        }
        return false;
    }
}
