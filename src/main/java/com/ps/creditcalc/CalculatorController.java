package com.ps.creditcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private ResultsCache resultsCache;

    @Autowired
    private LoanDataValidators validationService;

    @GetMapping("/")
    public String showCalculator(Model model) {

        LoanDTO loanDTO = new LoanDTO();
        model.addAttribute("loanData", loanDTO);
        model.addAttribute("resultsList", resultsCache.showResults());

        return "index";
    }

    @PostMapping("/")
    public String calculate(LoanDTO loanDTO, Model model) {

        final Map<String, String> exceptionMap = validationService.validateData(loanDTO);
        model.addAttribute("loanData", loanDTO);

        if(exceptionMap.isEmpty()) {
            if(loanDTO.getCommission().matches("0")) {
                loanDTO.setCommission("0");
            }
            String result = calculatorService.calculatePayment(loanDTO);
            String interestCost = calculatorService.calculateInterestCost(loanDTO);
            String commissionCost = calculatorService.calculateCommissionCost(loanDTO);
            String totalCost = calculatorService.calculateTotalCost(loanDTO);
            model.addAttribute("resultsList", resultsCache.addAndShowResults(loanDTO, result, interestCost, totalCost));
            model.addAttribute("result", result);
            model.addAttribute("interestCost", interestCost);
            model.addAttribute("commissionCost", commissionCost);
            model.addAttribute("totalCost", totalCost);
        } else {
            model.addAllAttributes(exceptionMap);
            model.addAttribute("resultsList", resultsCache.showResults());
        }

        return "index";
    }
}