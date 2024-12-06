package calculator.numbers;

import calculator.delimiter.Delimiter;

import java.util.List;

public class NumbersReader {
    public List<Integer> read(Delimiter delimiter, String line) {
        List<String> numbers = delimiter.split(line);
        try {
            return numbers.stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
