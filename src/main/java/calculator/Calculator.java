package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterReader;
import calculator.numbers.PositiveNumbersReader;

import java.util.List;

public class Calculator {
    private final DelimiterReader delimiterReader;
    private final PositiveNumbersReader positiveNumbersReader;

    public Calculator(DelimiterReader delimiterReader, PositiveNumbersReader positiveNumbersReader) {
        this.delimiterReader = delimiterReader;
        this.positiveNumbersReader = positiveNumbersReader;
    }

    public int sum(String line) {
        Delimiter delimiter = delimiterReader.read(line);
        List<Integer> numbers = positiveNumbersReader.read(delimiter, line);

        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
