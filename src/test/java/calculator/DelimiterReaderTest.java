package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterReaderTest {

    DelimiterReader reader = new DelimiterReader();

    @Test
    void 기본_구분자_읽기() {
        assertEquals(Pattern.quote(",:"), reader.read("1,2:3"));
    }

    @Test
    void 커스텀_구분자_읽기() {
        assertEquals(Pattern.quote("A"), reader.read("//A\n1,2:3"));
    }

    @Test
    void 여러개의_커스텀_구분자() {
        assertThrows(IllegalArgumentException.class, () -> reader.read("//A\n//B\n1,2:3"));
    }

}