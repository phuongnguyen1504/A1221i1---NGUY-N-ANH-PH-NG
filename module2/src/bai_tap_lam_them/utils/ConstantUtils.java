package bai_tap_lam_them.utils;

public interface ConstantUtils {
    interface PATH{
        String TRUCK="src/bai_tap_lam_them/data/truck.csv";
        String CAR="src/bai_tap_lam_them/data/car.csv";
        String MOTORBIKE="src/bai_tap_lam_them/data/motorbike.csv";
        String BRAND="src/bai_tap_lam_them/data/hangSanXuat.csv";

        static String setPath(String name) {
            String value="";
            switch (name){
                case "TRUCK":
                    value=TRUCK;
                    break;
                case "CAR":
                    value=CAR;
                    break;
                case "MOTORBIKE":
                    value=MOTORBIKE;
                    break;
            }
            return value;
        }
        }
    }

