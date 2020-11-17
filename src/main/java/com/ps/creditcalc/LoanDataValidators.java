package com.ps.creditcalc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoanDataValidators {

    public Map<String, String> validateData (LoanDTO loanDTO) {

        Map<String, String> exceptionsMap = new HashMap<>();

        if(!loanDTO.getLoanAmount().matches("^^[1-9][0-9][0-9][0-9]{1,5}$")) {
            exceptionsMap.put("loanAmountValidation", "Loan amount incorrect format, enter integer value between 1000 - 9999999");
        }

        try {
            BigDecimal ir = new BigDecimal(loanDTO.getInterestRate());
            if(ir.scale() > 2
                    || ir.compareTo(new BigDecimal("30")) > 0
                    || ir.compareTo(new BigDecimal("0")) < 0) {
                exceptionsMap.put("interestRate", "Interest rate incorrect format. Enter value between 0.01 - 30 with optional 2 digits after decimal point");
            }
        } catch (NumberFormatException e) {
            exceptionsMap.put("interestRate", "Interest rate incorrect format. Enter value between 0.01 - 30 with optional 2 digits after decimal point");
            System.out.println(e.getMessage());
        }

        try {
            int q = Integer.parseInt(loanDTO.getPaymentQuantity());
            if(q < 2 || q > 360) {
                exceptionsMap.put("payments", "Payment quantity incorrect format. Enter integer value between 2-360");
            }
        } catch (NumberFormatException e) {
            exceptionsMap.put("payments", "Payment quantity incorrect format. Enter integer value between 2-360");
            System.out.println(e.getMessage());
        }

        return exceptionsMap;
    }

}