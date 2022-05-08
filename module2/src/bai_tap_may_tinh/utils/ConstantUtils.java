package bai_tap_may_tinh.utils;

public interface ConstantUtils {
    interface PATH {
        String XACHTAY = "src/bai_tap_may_tinh/repository/xachtay.csv";
        String CHINHHANG = "src/bai_tap_may_tinh/repository/chinhhang.csv";

        static String getPATH(String name) {
            if (name.equals("CHINHHANG")) {
                return CHINHHANG;
            } else if (name.equals("XACHTAY")) {
                return XACHTAY;
            } else {
                return null;
            }
        }
    }
}
