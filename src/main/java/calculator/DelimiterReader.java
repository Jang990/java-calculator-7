package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterReader {
    private static final String regex = "//(.*?)\n";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(regex);
    private final String DEFAULT_DELIMITER = ",:";

    public String read(String line) {
        Matcher matcher = DELIMITER_PATTERN.matcher(line);
        if(matcher.find())
            return Pattern.quote(matcher.group(1));
        return Pattern.quote(DEFAULT_DELIMITER);
    }
}
