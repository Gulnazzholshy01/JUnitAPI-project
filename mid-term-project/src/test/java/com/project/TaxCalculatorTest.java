package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test; 

// A test class for the TaxCalculator class.

public class TaxCalculatorTest {
    
    // Test case to ensure that an IllegalArgumentException is thrown when a negative salary is provided
    @Test
    public void testCalculateTaxWithNegativeSalary() {
        TaxCalculator taxCalculator = new TaxCalculator();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,                         
                            () -> { taxCalculator.calculateTax(-10000);  });

        assertEquals("Salary cannot be negative", exception.getMessage());
    }

    //Test case to calculate tax for a salary below the first tax bracket
    @Test
    public void testCalculateTaxBelowBracket1() {
        TaxCalculator taxCalculator = new TaxCalculator();
        
        double tax = taxCalculator.calculateTax(30000);
        double expected = 3000;
        
        assertEquals(expected, tax); // 10% tax rate for $30,000
    }

    //Test case to calculate tax for a salary within the first tax bracket
    @Test
    public void testCalculateTaxInBracket1() {
        TaxCalculator taxCalculator = new TaxCalculator();
        
        double tax = taxCalculator.calculateTax(50000);
        
        assertEquals(6000, tax); // $4,0000 at 10% + $10,000 at 20%
    }

    //Test case to calculate tax for a salary within the second tax bracket.
    @Test
    public void testCalculateTaxInBracket2() {
        TaxCalculator taxCalculator = new TaxCalculator();
        
        double tax = taxCalculator.calculateTax(60000);
        
        assertEquals(8000, tax); // $4,0000 at 10% + $20,000 at 20%
    }

    //Test case to calculate tax for a salary within the second tax bracket.
    @Test
    public void testCalculateTaxAboveBracket2() {
        TaxCalculator taxCalculator = new TaxCalculator();
        
        double tax = taxCalculator.calculateTax(80000);
        
        assertEquals(14000, tax); // $4,0000 at 10% + $20,000 at 20% + $20,000 at 30%
    }
}