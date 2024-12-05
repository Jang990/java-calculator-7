package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterReader {
    private static final String regex = "//(.*?)\n";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(regex);
    private final String DEFAULT_DELIMITER = ",:";
    private final int SINGLE = 1;

    public String read(String line) {
        if(countDelimiterFormat(line) > SINGLE)
            throw new IllegalArgumentException();
        Matcher matcher = DELIMITER_PATTERN.matcher(line);
        if(matcher.find())
            return Pattern.quote(matcher.group(1));
        return Pattern.quote(DEFAULT_DELIMITER);
    }

    private int countDelimiterFormat(String line) {
        Matcher matcher = DELIMITER_PATTERN.matcher(line);
        int result = 0;
        while(matcher.find())
            result++;
        return result;
    }
}
