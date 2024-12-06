package calculator.delimiter;

import calculator.delimiter.Delimiter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    @Test
    void 구분자에_값이_같다면_같은_구분자() {
        assertEquals(new Delimiter(";"), new Delimiter(";"));
        assertFalse(new Delimiter(";").equals(new Delimiter(".")));
    }

    @Test
    void 구분자를_통한_분리기능_추가() {
        Delimiter delimiter = new Delimiter(";");
        assertEquals(List.of("1", "2", "3"), delimiter.split("//;\n1;2;3"));
    }

    @Test
    void 기본구분자_분리기능_추가() {
        Delimiter delimiter = new Delimiter();
        assertEquals(List.of("1", "2", "3"), delimiter.split("1:2,3"));
    }

}