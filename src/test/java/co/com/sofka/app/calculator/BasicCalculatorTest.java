package co.com.sofka.app.calculator;

import app.calculator.BasicCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101",
            "-30, -10, -40"
    })
    void severalSums(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subs")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1, 1, 0",
            "10, 5, 5",
            "-1, -1, 0",
            "-10, 5, -15"
    })
    void severalSubs(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.subs(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "1, 1, 1",
            "10, 5, 50",
            "-1, -1, 1",
            "-3, 5, -15"
    })
    void severalMult(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.mult(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divs")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "1, 1, 1",
            "10, 5, 2",
            "15, 3, 5"
    })
    void severalDivs(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @Test()
    @DisplayName("Testing div: 1/0=ArithmeticEx")
    void ZeroDiv() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 0L;
        ArithmeticException expectedValue = new ArithmeticException();

        // Act
        Long result = basicCalculator.div(number1, number2);

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }

}
