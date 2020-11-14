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

    @GetMapping("/")
    public String showCalculator(Model model) {
        LoanDTO loanDto = new LoanDTO();
        model.addAttribute("loanData", loanDto);
        return "calculatorForm";
    }

    @PostMapping("/")
    public String calculate(LoanDTO loanDto, Model model) {
        String result = calculatorService.calculatePayment(loanDto);
        model.addAttribute("loanData", loanDto);
        model.addAttribute("result", result);
        return "calculatorForm";
    }
}
