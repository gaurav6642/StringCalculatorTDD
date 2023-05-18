import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("Empty string should return 0")
    public void testAddWithEmptyString() {
        int result = calculator.add("");
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Single number should return the number itself")
    public void testAddWithSingleNumber() {
        int result = calculator.add("1");
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("Two numbers should return their sum")
    public void testAddWithTwoNumbers() {
        int result = calculator.add("1,2");
        Assertions.assertEquals(3, result);
    }

    @Test
    @DisplayName("Unknown amount of numbers should return their sum")
    public void testAddWithUnknownAmountOfNumbers() {
        int result = calculator.add("1,2,3,4,5");
        Assertions.assertEquals(15, result);
    }

    @Test
    @DisplayName("Support new lines between numbers")
    public void testAddWithNewLinesBetweenNumbers() {
        int result = calculator.add("1\n2,3");
        Assertions.assertEquals(6, result);
    }

    @Test
    @DisplayName("Custom delimiter should be supported")
    public void testAddWithCustomDelimiter() {
        int result = calculator.add("//;\n1;2");
        Assertions.assertEquals(3, result);
    }

}

