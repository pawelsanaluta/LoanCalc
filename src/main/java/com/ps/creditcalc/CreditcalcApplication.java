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
1. historical results
2. tips how to enter values
3. validators
4. footer
5. loan details, interest cost, commission
*/

