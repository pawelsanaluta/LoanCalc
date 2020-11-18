package com.ps.creditcalc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoanDataValidators {

    private static final String AMOUNT_ERROR = "Loan amount incorrect input, enter integer value between 1000 - 9999999";
    private static final String RATE_ERROR = "Interest rate incorrect input. Enter value between 0,01 - 30 with optional 2 digits after decimal point";
    private static final String PAYMENTS_ERROR = "Payment quantity incorrect input. Enter integer value between 2-360";

    public Map<String, String> validateData(LoanDTO loanDTO) {

        Map<String, String> exceptionsMap = new HashMap<>();

        if (!loanDTO.getLoanAmount().matches("^^[1-9][0-9][0-9][0-9]{1,5}$")) {
            exceptionsMap.put("loanAmountValidation", AMOUNT_ERROR);
        }

        try {
            BigDecimal ir = new BigDecimal(loanDTO.getInterestRate());
            if (ir.scale() > 2
                    || ir.compareTo(new BigDecimal("30")) > 0
                    || ir.compareTo(new BigDecimal("0")) < 0) {
                exceptionsMap.put("interestRate", RATE_ERROR);
            }
        } catch (NumberFormatException e) {
            exceptionsMap.put("interestRate", RATE_ERROR);
            System.out.println(e.getMessage());
        }

        try {
            int q = Integer.parseInt(loanDTO.getPaymentQuantity());
            if (q < 2 || q > 360) {
                exceptionsMap.put("payments", PAYMENTS_ERROR);
            }
        } catch (NumberFormatException e) {
            exceptionsMap.put("payments", PAYMENTS_ERROR);
            System.out.println(e.getMessage());
        }

        return exceptionsMap;
    }
}