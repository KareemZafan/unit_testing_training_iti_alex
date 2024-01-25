package org.iti.alex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    void setUpTests() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(2, 8));
    }

    @Test
    void testSubtraction() {
        assertEquals(-6, calculator.subtract(2, 8));
    }

    @Test
    void testMultiplication() {
        assertEquals(16, calculator.multiply(2, 8));
    }

    @Test
    void testDivision() {
        assertEquals(4, calculator.divide(8, 2));
        assertEquals(0, calculator.divide(0, 2));
        assertEquals(-25, calculator.divide(-50, 2));
        assertEquals(-20,calculator.divide(80,-4));
        var exception = assertThrowsExactly(ArithmeticException.class,()->calculator.divide(4,0));
        assertEquals("Dividing By Zero", exception.getMessage());

    }

    @Test
    void testSquareRoot() {
        assertEquals(4, calculator.squareRoot(16));
    }

}