package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test; 

public class TaxCalculatorTestWithLifeCycle {

    private TaxCalculator taxCalculator; 

    @BeforeAll
    public static void init(){
        System.out.println("TaxCalculator test has started!");
    }

    @BeforeEach
    public void setup(){
        taxCalculator = new TaxCalculator();
    }
    
    
    @Test
    public void testCalculateTaxWithNegativeSalary() {
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,                         
                            () -> { taxCalculator.calculateTax(-10000);  });

        assertEquals("Salary cannot be negative", exception.getMessage());
    }

    @Test
    public void testCalculateTaxBelowBracket1() {
        
        double tax = taxCalculator.calculateTax(30000);
        double expected = 3000;
        
        assertEquals(expected, tax); // 10% tax rate for $30,000
    }

    @Test
    public void testCalculateTaxInBracket1() {
        
        double tax = taxCalculator.calculateTax(50000);
        
        assertEquals(6000, tax); // $4,0000 at 10% + $10,000 at 20%
    }

    @Test
    public void testCalculateTaxInBracket2() {
        
        double tax = taxCalculator.calculateTax(60000);
        
        assertEquals(8000, tax); // $4,0000 at 10% + $20,000 at 20%
    }

    @Test
    @Disabled
    public void testCalculateTaxAboveBracket2() {
        
        double tax = taxCalculator.calculateTax(80000);
        
        assertEquals(14000, tax); // $4,0000 at 10% + $20,000 at 20% + $20,000 at 30%
    }

    @AfterAll
    public static void done(){
        System.out.println("TaxCalculator test has finished!");
    } 
}