package calculator.delimiter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Delimiter {
    public static final String DEFAULT_REGEX = ",|:";

    private static final String template = "//%s\n";
    private String value;

    protected Delimiter() {
        this.value = DEFAULT_REGEX;
    }

    protected Delimiter(String value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(value, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public List<String> split(String line) {
        if(value.equals(DEFAULT_REGEX))
            return Arrays.stream(line.split(value)).toList();

        String args = line.replace(template.formatted(value), "");
        return Arrays.stream(args.split(Pattern.quote(value)))
                .toList();
    }
}
