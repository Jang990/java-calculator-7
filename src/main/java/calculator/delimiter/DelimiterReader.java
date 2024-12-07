package calculator.delimiter;

import java.util.regex.Pattern;

public class DelimiterReader {
    private static final String regex = "//(.*?)\\n";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(regex);
    private static final String DELIMITER_FORMAT_PREFIX = "//";
    private static final String ARGUMENT_DELIMITER = "\\n";
    private final int SINGLE = 1;

    public Delimiter read(String line) {
        if(notFoundDelimiterFormat(line))
            return new Delimiter();
        if(countDelimiterFormat(line) != SINGLE)
            throw new IllegalArgumentException();
        return parseDelimiter(line);
    }

    private static Delimiter parseDelimiter(String line) {
        return new Delimiter(parseDelimiterValue(line));
    }

    private static String parseDelimiterValue(String line) {
        return getArguments(line)[0].replace(DELIMITER_FORMAT_PREFIX, "");
    }

    private boolean notFoundDelimiterFormat(String line) {
        return countDelimiterFormat(line) == 0;
    }

    private int countDelimiterFormat(String line) {
        int result = 0;
        for (String argument : getArguments(line)) {
            if(argument.startsWith(DELIMITER_FORMAT_PREFIX))
                result++;
        }
        return result;
    }

    private static String[] getArguments(String line) {
        return line.split(Pattern.quote(ARGUMENT_DELIMITER));
    }
}
