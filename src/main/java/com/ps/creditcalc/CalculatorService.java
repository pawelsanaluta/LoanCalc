package com.ps.creditcalc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public BigDecimal calculatePayment(Loan loan) {

        BigDecimal payment = BigDecimal.valueOf(0);
        BigDecimal dividend = loan.getLoanAmount();
        BigDecimal divisor = BigDecimal.valueOf(0);
        RoundingMode rm = RoundingMode.HALF_UP;

        BigDecimal monthlyInterestRate = loan.getInterestRate().divide(BigDecimal.valueOf(12), 8, rm);
        for (int i = 1; i <= loan.getPaymentQuantity(); i++) {
            divisor = (monthlyInterestRate.add(BigDecimal.valueOf(1))).pow(-i);
        }
        try {
            payment = dividend.divide(divisor, 2, rm);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        return payment;
    }
}
