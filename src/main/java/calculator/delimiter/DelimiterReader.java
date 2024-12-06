package calculator.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterReader {
    private static final String regex = "//(.*?)\n";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(regex);
    private final int SINGLE = 1;

    public Delimiter read(String line) {
        if(notFoundDelimiterFormat(line))
            return new Delimiter();
        if(countDelimiterFormat(line) != SINGLE)
            throw new IllegalArgumentException();
        return parseDelimiter(line);
    }

    private static Delimiter parseDelimiter(String line) {
        Matcher matcher = DELIMITER_PATTERN.matcher(line);
        matcher.find();
        return new Delimiter(matcher.group(1));
    }

    private boolean notFoundDelimiterFormat(String line) {
        return countDelimiterFormat(line) == 0;
    }

    private int countDelimiterFormat(String line) {
        Matcher matcher = DELIMITER_PATTERN.matcher(line);
        int result = 0;
        while(matcher.find())
            result++;
        return result;
    }
}
