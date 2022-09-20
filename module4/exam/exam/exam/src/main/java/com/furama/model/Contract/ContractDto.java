package com.furama.model.Contract;

import com.furama.repository.Contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class ContractDto {
    @Autowired
    private ContractRepository customerRepository;


    @Pattern(regexp = "^HD-\\d{4}$",message = "Phai nhap dung dinh dang HD-XXXX (X là số từ 0-9)")
    private String contractcode;
    @NotBlank(message = "Khong duoc de trong")
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateContract;
    private String timeRent;
    @NotBlank(message = "Khong duoc de trong")
    private String cmnd;

    private String money;
//    @Pattern(regexp = "^0\\d{9}$",message = "Phai nhap dung 9 so bat dau tu 0")
    private String phone;
//    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Mail khong dung dinh dang nhap lai")
//    private String mail;

    private String roomcode;

    public ContractDto() {
    }

    public String getContractcode() {
        return contractcode;
    }

    public void setContractcode(String contractcode) {
        this.contractcode = contractcode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContractRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(ContractRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public LocalDate getDateContract() {
        return dateContract;
    }

    public void setDateContract(LocalDate dateContract) {
        this.dateContract = dateContract;
    }

    public String getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(String timeRent) {
        this.timeRent = timeRent;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors e) {
//        ContractDto c = (ContractDto) target;
//        String val= c.getCustomer_id();
//        Optional<Contract> customer=customerRepository.findById(val);
//        if(customer.isPresent()){
//            e.rejectValue("customer_id","duplicate.customer.id","Bi trung ma khach hang");
//        }
//
//    }

}
