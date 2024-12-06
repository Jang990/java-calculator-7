package calculator.numbers;

import calculator.delimiter.DelimiterStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersReaderTest {

    private NumbersReader numbersReader = new NumbersReader();

    @Test
    void 구분자를_통해_숫자_읽기() {
        DelimiterStub delimiter = new DelimiterStub();
        delimiter.setTestValue(List.of("1", "2", "3"));

        assertEquals(List.of(1, 2, 3), numbersReader.read(delimiter, ""));
    }

}