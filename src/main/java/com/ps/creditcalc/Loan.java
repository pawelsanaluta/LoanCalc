package com.ps.creditcalc;

import java.math.BigDecimal;
/*
Loan class that defines amount of a loan, its interest rate and quantity of monthly payments (monthly duration).
 */
public class Loan {

    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer paymentQuantity;

    public Loan(BigDecimal loanAmount, BigDecimal interestRate, Integer paymentQuantity) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.paymentQuantity = paymentQuantity;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void setPaymentQuantity(Integer paymentQuantity) {
        this.paymentQuantity = paymentQuantity;
    }

    public BigDecimal getLoanAmount() {
        return this.loanAmount;
    }

    public BigDecimal getInterestRate() {
        return this.interestRate;
    }

    public Integer getPaymentQuantity() {
        return this.paymentQuantity;
    }
}
