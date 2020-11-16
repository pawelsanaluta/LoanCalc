package com.ps.creditcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private ResultsCache resultsCache;

    @GetMapping("/")
    public String showCalculator(Model model) {
        LoanDTO loanDTO = new LoanDTO();
        model.addAttribute("loanData", loanDTO);
        return "index";
    }

    @PostMapping("/")
    public String calculate(LoanDTO loanDTO, Model model) {
        model.addAttribute("loanData", loanDTO);
        String result = calculatorService.calculatePayment(loanDTO);
        String cost = calculatorService.calculateLoanCost(loanDTO);
        model.addAttribute("resultsList", resultsCache.addAndShowResults(loanDTO, result, cost));
        model.addAttribute("result", result);
        model.addAttribute("cost", cost);
        return "index";
    }
}
