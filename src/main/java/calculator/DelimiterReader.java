package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterReader {
    private static final String regex = "//(.*?)\n";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(regex);
    private final String DEFAULT_DELIMITER = ",:";
    private final int SINGLE = 1;

    public String read(String line) {
        if(notFoundDelimiterFormat(line))
            return Pattern.quote(DEFAULT_DELIMITER);
        if(countDelimiterFormat(line) != SINGLE)
            throw new IllegalArgumentException();
        return parseDelimiter(line);
    }

    private static String parseDelimiter(String line) {
        Matcher matcher = DELIMITER_PATTERN.matcher(line);
        matcher.find();
        return Pattern.quote(matcher.group(1));
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
