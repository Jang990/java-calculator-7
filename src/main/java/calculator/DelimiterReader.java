package calculator;

import java.util.regex.Pattern;

public class DelimiterReader {
    public String read(String line) {
        return Pattern.quote(",:");
    }
}
