package calculator.delimiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterReaderTest {

    DelimiterReader reader = new DelimiterReader();

    @Test
    void 기본_구분자_읽기() {
        assertEquals(new Delimiter(), reader.read("1,2:3"));
    }

    @Test
    void 커스텀_구분자_읽기() {
        assertEquals(new Delimiter("A"), reader.read("//A\\n1,2:3"));
    }

    @Test
    void 여러개의_커스텀_구분자() {
        assertThrows(IllegalArgumentException.class, () -> reader.read("//A\\n//B\\n1,2:3"));
    }

}