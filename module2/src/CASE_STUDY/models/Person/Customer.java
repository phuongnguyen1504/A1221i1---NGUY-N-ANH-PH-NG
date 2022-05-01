package CASE_STUDY.models.Person;

public class Customer extends Person{
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String codeOfPerson, String name, String dateOfBirth, String gender,
                    int id, int tel, String email, String typeCustomer, String address) {
        super(codeOfPerson, name, dateOfBirth, gender, id, tel, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
