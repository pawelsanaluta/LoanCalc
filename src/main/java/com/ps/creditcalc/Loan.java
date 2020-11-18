package com.ps.creditcalc;

import java.math.BigDecimal;

/*
Loan class that defines amount of a loan, its interest rate and quantity of monthly payments (monthly duration).
 */
public class Loan {

    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer paymentQuantity;
    private BigDecimal commission;

    public Loan(BigDecimal loanAmount, BigDecimal interestRate, Integer paymentQuantity, BigDecimal commission) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.paymentQuantity = paymentQuantity;
        this.commission = commission;
    }

    public Loan() {
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

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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

    public BigDecimal getCommission() {
        return this.commission;
    }

    public static Loan apply(LoanDTO loanDTO) {
        final Loan loan = new Loan();
        loan.setLoanAmount(new BigDecimal(loanDTO.getLoanAmount()));
        loan.setInterestRate(new BigDecimal(loanDTO.getInterestRate()));
        loan.setPaymentQuantity(Integer.parseInt(loanDTO.getPaymentQuantity()));
        loan.setCommission(new BigDecimal(loanDTO.getCommission()));
        return loan;
    }
}
