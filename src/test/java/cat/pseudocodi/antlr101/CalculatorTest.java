package cat.pseudocodi.antlr101;

import org.junit.Ignore;
import org.junit.Test;

import static cat.pseudocodi.antlr101.Calculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Ignore
    @Test
    public void shouldParseIntegers() {
        assertThat(calculate("123")).isEqualTo(123);
    }

    @Ignore
    @Test
    public void shouldSumTwoNumbers() {
        String expression = "2 + 5";
        assertThat(calculate(expression)).isEqualTo(7);
    }

    @Ignore
    @Test
    public void shouldMoreThanSumTwoNumbers() {
        String expression = "2 + 5 + 10";
        assertThat(calculate(expression)).isEqualTo(17);
    }

    @Ignore
    @Test
    public void shouldSubtractNumbers() {
        String expression = "2 - 5 + 10";
        assertThat(calculate(expression)).isEqualTo(7);
    }

    @Ignore
    @Test
    public void shouldMultiplyAndDivideNumbers() {
        String expression = "2 * 5 / 2 + 1";
        assertThat(calculate(expression)).isEqualTo(6);
    }

    @Ignore
    @Test
    public void shouldUseParenthesis() {
        String expression = "(2 + 5) * 2";
        assertThat(calculate(expression)).isEqualTo(14);
    }

    @Ignore
    @Test
    public void shouldUseNestedParenthesis() {
        String expression = "(1 + (1 + (1)))";
        assertThat(calculate(expression)).isEqualTo(3);
    }

    @Ignore
    @Test
    public void shouldCalculateSquares() {
        String expression = "sqr(2) + sqr(3)";
        assertThat(calculate(expression)).isEqualTo(13);
    }

    @Ignore
    @Test
    public void shouldCalculateCubes() {
        String expression = "cube(1 + 1)";
        assertThat(calculate(expression)).isEqualTo(8);
    }
}
