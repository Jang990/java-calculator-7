package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterReader;
import calculator.numbers.NumbersReader;

import java.util.List;

public class Calculator {
    private final DelimiterReader delimiterReader;
    private final NumbersReader numbersReader;

    public Calculator(DelimiterReader delimiterReader, NumbersReader numbersReader) {
        this.delimiterReader = delimiterReader;
        this.numbersReader = numbersReader;
    }

    public int sum(String line) {
        Delimiter delimiter = delimiterReader.read(line);
        List<Integer> numbers = numbersReader.read(delimiter, line);

        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
