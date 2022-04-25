package CASE_STUDY.models;

public class Contract extends Booking{
    private String contractCode;
    private int deposit;
    private int totalPayment;

    public Contract() {
    }

    public Contract(String bookingCode, String bookingStart, String bookingEnd, String customerCode,
                    String nameOfService, String typeOfService, String contractCode, int deposit,
                    int totalPayment) {
        super(bookingCode, bookingStart, bookingEnd, customerCode, nameOfService, typeOfService);
        this.contractCode = contractCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
}
