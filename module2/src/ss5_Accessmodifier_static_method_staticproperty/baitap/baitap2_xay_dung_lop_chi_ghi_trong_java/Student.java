package ss5_Accessmodifier_static_method_staticproperty.baitap.baitap2_xay_dung_lop_chi_ghi_trong_java;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Student {
    private String name="John";
    private String classes="C02";

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setClasses(String classes){
        this.classes=classes;
    }

    public String getClasses() {
        return classes;
    }
}
