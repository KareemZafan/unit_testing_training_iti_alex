package org.iti.alex;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {
    private Calculator calculator;

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("1", "1", "2"),
                Arguments.of("0", "100", "100"),
                Arguments.of("1", "-1", "0")
        );
    }

    @BeforeEach
    void setUpTests() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    //@CsvFileSource( resources= "/data.csv", numLinesToSkip = 1)
    @MethodSource("provideData")
    void testAddition(String input1, String input2, String expectedValue) {
        assertEquals(Double.parseDouble(expectedValue), calculator.add(Double.parseDouble(input1), Double.parseDouble(input2)));
    }

    @RepeatedTest(4)
    void testSubtraction() {
        assertEquals(-6, calculator.subtract(2, 8));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.MINUTES)
    void testMultiplication() {
        assertEquals(16, calculator.multiply(2, 8));
    }

    @Test
    @Tag("Feb")
    void testDivision() {
        assertEquals(4, calculator.divide(8, 2));
        assertEquals(0, calculator.divide(0, 2));
        assertEquals(-25, calculator.divide(-50, 2));
        assertEquals(-20, calculator.divide(80, -4));
        var exception = assertThrowsExactly(ArithmeticException.class, () -> calculator.divide(4, 0));
        assertEquals("Dividing By Zero", exception.getMessage());

    }

    @Test
    @Tag("Feb")
    void testSquareRoot() {
        assertEquals(4, calculator.squareRoot(16));
    }

}