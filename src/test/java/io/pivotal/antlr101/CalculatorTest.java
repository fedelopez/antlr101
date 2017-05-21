package io.pivotal.antlr101;

import org.junit.Test;

import static io.pivotal.antlr101.Calculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void shouldReturnAnInteger() {
        assertThat(calculate("123")).isEqualTo(123);
    }

    @Test
    public void shouldSumTwoNumbers() {
        String expression = "2 + 5";
        assertThat(calculate(expression)).isEqualTo(7);
    }

    @Test
    public void shouldMoreThanSumTwoNumbers() {
        String expression = "2 + 5 + 10";
        assertThat(calculate(expression)).isEqualTo(17);
    }

    @Test
    public void shouldSubtractNumbers() {
        String expression = "2 - 5 + 10";
        assertThat(calculate(expression)).isEqualTo(7);
    }

    @Test
    public void shouldMultiplyAndDivideNumbers() {
        String expression = "2 * 5 / 2 + 1";
        assertThat(calculate(expression)).isEqualTo(6);
    }

   @Test
    public void shouldUseParenthesis() {
        String expression = "(2 + 5) * 2";
        assertThat(calculate(expression)).isEqualTo(14);
    }

   @Test
    public void shouldUseNestedParenthesis() {
        String expression = "(1 + (1 + (1)))";
        assertThat(calculate(expression)).isEqualTo(3);
    }

   @Test
    public void shouldCalculateSquares() {
        String expression = "sqr(2) + sqr(3)";
        assertThat(calculate(expression)).isEqualTo(13);
    }

   @Test
    public void shouldCalculateCubes() {
        String expression = "cube(1 + 1)";
        assertThat(calculate(expression)).isEqualTo(8);
    }
}
