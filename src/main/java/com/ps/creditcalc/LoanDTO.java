package com.ps.creditcalc;

public class LoanDTO {

    private String loanAmount;
    private String interestRate;
    private Integer paymentQuantity;

    public LoanDTO(String loanAmount, String interestRate, Integer paymentQuantity) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.paymentQuantity = paymentQuantity;
    }

    public LoanDTO() {
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public Integer getPaymentQuantity() {
        return paymentQuantity;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public void setPaymentQuantity(Integer paymentQuantity) {
        this.paymentQuantity = paymentQuantity;
    }
}
