package com.furama.model.Customer;

import com.furama.repository.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Optional;

public class CustomerDto  {
    @Autowired
    private CustomerRepository customerRepository;
    @Pattern(regexp = "^KH-\\d{4}$",message = "Phai nhap dung dinh dang KH-XXXX (X là số từ 0-9)")
    private String customer_id;
    @NotBlank(message = "Khong duoc de trong")
    private String name;
    private LocalDate birthday;
    private String gender;
    private String idcard;
//    @Pattern(regexp = "^0\\d{9}$",message = "Phai nhap dung 9 so bat dau tu 0")
    private String phone;
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Mail khong dung dinh dang nhap lai")
    private String mail;
    private String address;
    private int customerTypeId;

    public CustomerDto() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors e) {
//        CustomerDto c = (CustomerDto) target;
//        String val= c.getCustomer_id();
//        Optional<Customer> customer=customerRepository.findById(val);
//        if(customer.isPresent()){
//            e.rejectValue("customer_id","duplicate.customer.id","Bi trung ma khach hang");
//        }
//
//    }

}
