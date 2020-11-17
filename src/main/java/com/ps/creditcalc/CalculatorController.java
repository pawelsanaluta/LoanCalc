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
        if(exceptionMap.isEmpty()) {
            model.addAttribute("loanData", loanDTO);
            String result = calculatorService.calculatePayment(loanDTO);
            String cost = calculatorService.calculateLoanCost(loanDTO);
            model.addAttribute("resultsList", resultsCache.addAndShowResults(loanDTO, result, cost));
            model.addAttribute("result", result);
            model.addAttribute("cost", cost);
        } else {
            model.addAttribute("loanData", loanDTO);
            model.addAllAttributes(exceptionMap);
            model.addAttribute("resultsList", resultsCache.showResults());
        }
        return "index";
    }
}
