package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterReaderTest {

    DelimiterReader reader = new DelimiterReader();

    @Test
    void 기본_구분자_읽기() {
        String delimiter = reader.read("1,2:3");
        assertEquals(Pattern.quote(",:"), delimiter);
    }

}