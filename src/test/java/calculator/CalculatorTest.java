package calculator;

import calculator.delimiter.DelimiterReader;
import calculator.numbers.NumbersReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator(new DelimiterReader(), new NumbersReader());

    @Test
    void 기본_구분자를_통해_더하기() {
        assertEquals(6, calculator.sum("1:2,3"));
        assertEquals(6, calculator.sum("1,2:3"));
    }

    @Test
    void 커스텀_구분자를_통해_더하기() {
        assertEquals(6, calculator.sum("//A\n1A2A3"));
    }
}