package com.ps.creditcalc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void bigDecimalTest() {
        final BigDecimal bigDecimal = new BigDecimal("1.000");
        System.out.println(bigDecimal.scale());
    }

    @Test
    public void testEquality() {
        final BigDecimal bd1 = new BigDecimal("1.000");
        final BigDecimal bd2 = new BigDecimal("1");

        System.out.println(bd1.compareTo(bd2));
    }

    @Test
    public void testParsing(){
        final BigDecimal s = new BigDecimal("0,1");
        System.out.println(s.toString());
    }
}
