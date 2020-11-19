package com.ps.creditcalc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    private final RoundingMode rm = RoundingMode.HALF_UP;
    private final MathContext mc = new MathContext(10, rm);

    public String calculatePayment(LoanDTO loanDTO) {

        final Loan loan = Loan.apply(loanDTO);
        BigDecimal payment = BigDecimal.valueOf(0);
        final BigDecimal dividend = loan.getLoanAmount();
        BigDecimal divisor = BigDecimal.valueOf(0);
        final BigDecimal monthlyInterestRate = loan.getInterestRate().divide(BigDecimal.valueOf(1200), 8, rm);

        for (int i = 1; i <= loan.getPaymentQuantity(); i++) {
            final BigDecimal power = (monthlyInterestRate.add(BigDecimal.valueOf(1))).pow(-i, mc);
            divisor = divisor.add(power);
        }

        try {
            payment = dividend.divide(divisor, 2, rm);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        return payment.toString();
    }

    public String calculateInterestCost(LoanDTO loanDTO) {

        final String payment = calculatePayment(loanDTO);
        final BigDecimal cost = new BigDecimal(payment)
                .multiply(new BigDecimal(loanDTO.getPaymentQuantity()))
                .subtract(new BigDecimal(loanDTO.getLoanAmount()));

        return cost.toString();
    }

    public String calculateCommissionCost(LoanDTO loanDTO) {

        final Loan loan = Loan.apply(loanDTO);
        final BigDecimal multiplicand = loan.getCommission().divide(new BigDecimal("100"), 6, rm);
        final BigDecimal commissionValue = loan.getLoanAmount().multiply(multiplicand).setScale(2, rm);

        return commissionValue.toString();
    }

    public String calculateTotalCost(LoanDTO loanDTO) {

        final BigDecimal totalCost = new BigDecimal(calculateInterestCost(loanDTO))
                .add(new BigDecimal(calculateCommissionCost(loanDTO)));

        return totalCost.toString();
    }
}