package com.project;

/**
 * A class to calculate taxes based on salary.
 */

public class TaxCalculator {

    /**
     * Calculates the tax based on the given salary.
     *
     * @param salary The salary of the individual.
     * @return The calculated tax amount.
     * @throws IllegalArgumentException if the salary is negative.
     */
    
    public double calculateTax(double salary) {

        // Define tax rates and brackets
        final double TAX_RATE_10 = 0.10;
        final double TAX_RATE_20 = 0.20;
        final double TAX_RATE_30 = 0.30;
        final double BRACKET_1 = 40000;
        final double BRACKET_2 = 60000;

        // Check for negative salary
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        // Calculate tax based on salary
        double tax = 0;
        if (salary <= BRACKET_1) {
            tax = salary * TAX_RATE_10; // Apply 10% tax rate
        } else if (salary <= BRACKET_2) {
            // Apply 10% tax on first bracket, and 20% tax on the portion exceeding the first bracket
            tax = BRACKET_1 * TAX_RATE_10 + (salary - BRACKET_1) * TAX_RATE_20;
        } else {
            // Apply 10% tax on first bracket, 20% on second bracket, and 30% on the portion exceeding the second bracket
            tax = BRACKET_1 * TAX_RATE_10 + (BRACKET_2 - BRACKET_1) * TAX_RATE_20 + (salary - BRACKET_2) * TAX_RATE_30;
        }

        return tax;
    }
}