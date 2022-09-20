package com.furama.model.Contract;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    private String contractcode;
    private String name;
    private Integer cmnd;

    private String dateContract;
    private String timeRent;
    private String money;

//    @Column(columnDefinition = "boolean default false")
//    private boolean isDelete;
//
//    public boolean isDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(boolean delete) {
//        isDelete = delete;
//    }

    @ManyToOne
    @JoinColumn(name = "roomcode",referencedColumnName = "roomcode")
//    @JsonBackReference
    @JsonManagedReference
    private Room room;

    public Contract() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room customerType) {
        this.room = customerType;
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

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract(String birthday) {
        this.dateContract = birthday;
    }

    public String getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(String gender) {
        this.timeRent = gender;
    }

    public Integer getCmnd() {
        return cmnd;
    }

    public void setCmnd(Integer cmnd) {
        this.cmnd = cmnd;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String phone) {
        this.money = phone;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractcode.equals(contract.contractcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractcode);
    }
}
