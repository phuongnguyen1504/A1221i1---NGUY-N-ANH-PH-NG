package bai_tap_may_tinh.utils;

import static bai_tap_may_tinh.utils.Validate.isExistsId;

public class CheckId {
    private String id;

    public CheckId(String id) throws NotFoundProductException{
        this.id = id;
        if (!isExistsId(id,"CHINHHANG")&&!isExistsId(id,"XACHTAY")){
            throw new NotFoundProductException("Không tìm thấy ID cần xóa!");
        }
    }
}
