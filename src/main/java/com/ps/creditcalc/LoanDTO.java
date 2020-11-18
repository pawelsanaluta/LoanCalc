package com.ps.creditcalc;

import org.springframework.stereotype.Component;

@Component
public class LoanDTO {

    private String loanAmount;
    private String interestRate;
    private String paymentQuantity;
    private String commission;

    public LoanDTO(String loanAmount, String interestRate, String paymentQuantity, String commission) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.paymentQuantity = paymentQuantity;
        this.commission = commission;
    }

    public LoanDTO() {
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public String getPaymentQuantity() {
        return paymentQuantity;
    }

    public String getCommission() {
        return this.commission;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public void setPaymentQuantity(String paymentQuantity) {
        this.paymentQuantity = paymentQuantity;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }
}
