package com.ps.creditcalc;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class ResultsCache {

    private final List<String> results = new LinkedList<>();

    public List<String> addAndShowResults(LoanDTO loanDTO, String result, String interestCost, String totalCost) {
        String entry = "Amount: " + loanDTO.getLoanAmount() +
                ", interest rate: " + loanDTO.getInterestRate() +
                "%, duration: " + loanDTO.getPaymentQuantity() +
                " months, monthly payment: " + result +
                ", interest cost: " + interestCost +
                ", total cost: " + totalCost;

        Collections.reverse(results);
        results.add(entry);
        if (results.size() > 3) {
            results.remove(0);
        }
        Collections.reverse(results);

        return results;
    }

    public List<String> showResults() {
        return results;
    }
}