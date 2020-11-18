package com.ps.creditcalc;

/*
Simple application that returns value of monthly payment of a loan.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditcalcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditcalcApplication.class, args);
    }

}

/*TODO
1. tests
6. schedule creation, saving to file
7. 0% percentage exclude
8. fix commission input- no calc for decimal values, write validator
*/