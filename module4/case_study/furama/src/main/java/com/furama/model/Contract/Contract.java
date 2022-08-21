package com.furama.model.Contract;

import com.furama.model.Customer.Customer;
import com.furama.model.employee.Employee;
import com.furama.model.service.Service;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;
    private String contract_start_date;
    private String contract_end_date;
    private Double contract_deposit;
    private Double contract_total_money;
    @ManyToOne
    @JoinColumn(referencedColumnName = "employee_id",name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(referencedColumnName = "customer_id",name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "service_id",name = "service_id")
    private Service service;
    @OneToOne(mappedBy = "contract")
    private ContractDetail contractDetail;

    public Contract() {
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public Double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(Double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public Double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(Double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }
}
