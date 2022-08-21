package com.furama.model.Contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_detail_id;
    @OneToOne
    @JoinColumn(referencedColumnName = "contract_id",name = "contract_id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(referencedColumnName = "attach_service_id",name = "attach_service_id")
    private AttachService attachService;

    private int quantity;

    public ContractDetail() {
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
