package com.ps.creditcalc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public String calculatePayment(LoanDTO loanDTO) {

        Loan loan = Loan.apply(loanDTO);
        BigDecimal payment = BigDecimal.valueOf(0);
        BigDecimal dividend = loan.getLoanAmount();
        BigDecimal divisor = BigDecimal.valueOf(0);
        RoundingMode rm = RoundingMode.HALF_UP;
        MathContext mc = new MathContext(10, rm);

        BigDecimal monthlyInterestRate = loan.getInterestRate().divide(BigDecimal.valueOf(1200), 8, rm);
        for (int i = 1; i <= loan.getPaymentQuantity(); i++) {
            BigDecimal power = (monthlyInterestRate.add(BigDecimal.valueOf(1))).pow(-i, mc);
            divisor = divisor.add(power);
        }
        try {
            payment = dividend.divide(divisor, 2, rm);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        return payment.toString();
    }

    public String calculateLoanCost(LoanDTO loanDTO) {
        final String payment = calculatePayment(loanDTO);
        BigDecimal cost = new BigDecimal(payment).multiply(new BigDecimal(loanDTO.getPaymentQuantity())).subtract(new BigDecimal(loanDTO.getLoanAmount()));
        return cost.toString();
    }
}
