package FuramaCaseStudy.model;

import FuramaCaseStudy.util.ConstantUtil;

public class Customer extends Person{
    private ConstantUtil.TypeCustomer typeCustomer;

    public Customer() { }

    public Customer(int id, String code, String fullName, String birthday, ConstantUtil.Gender gender, String phone,
                    String email, String address, ConstantUtil.TypeCustomer typeCustomer) {
        super(id, code, fullName, birthday, gender, phone, email, address);
        this.typeCustomer = typeCustomer;
    }

    public ConstantUtil.TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(ConstantUtil.TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public boolean equals(Object o) {
        return getId()== ((Customer)o).getId();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", code='" + getCode() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", gender=" + getGender() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                "typeCustomer=" + typeCustomer +
                '}';
    }
}
