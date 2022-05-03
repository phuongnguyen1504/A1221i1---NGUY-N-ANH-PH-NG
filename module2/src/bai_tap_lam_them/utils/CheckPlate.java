package bai_tap_lam_them.utils;
import static bai_tap_lam_them.utils.Validate.*;

public class CheckPlate {
    private String plate;

    public CheckPlate() {
    }

    public CheckPlate(String plate) throws PlateException {
        this.plate = plate;
        if (!validatePlate(plate, "TRUCK", "") && !validatePlate(plate, "CAR", "Du lịch") && !validatePlate(plate, "CAR", "Xe khách")
                && !validatePlate(plate, "MOTORBIKE", "")) {
            throw new PlateException("Biển số không hợp lệ. Mời nhập lại biển số");
        }
        else if (!isExistsPlate(plate,"TRUCK")&&!isExistsPlate(plate,"CAR")&&!isExistsPlate(plate,"MOTORBIKE")){
            throw new PlateException("Biển kiểm soát không tồn tại. Nhập lại biển số hoặc nhấn enter để exit");
        }
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
