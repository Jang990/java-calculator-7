package calculator.numbers;

import calculator.delimiter.Delimiter;

import java.util.LinkedList;
import java.util.List;

public class NumbersReader {
    public List<Integer> read(Delimiter delimiter, String line) {
        List<String> numbers = delimiter.split(line);
        try {
            return parseToPositiveNumbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private List<Integer> parseToPositiveNumbers(List<String> numberStrings) {
        List<Integer> result = new LinkedList<>();
        for (String numberString : numberStrings) {
            result.add(toPositiveNumber(numberString));
        }
        return result;
    }

    private int toPositiveNumber(String numberString) {
        int number = Integer.parseInt(numberString);
        if(number < 0)
            throw new IllegalArgumentException();
        return number;
    }
}
