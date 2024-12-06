package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    @Test
    void 구분자에_값이_같다면_같은_구분자() {
        assertEquals(new Delimiter(";"), new Delimiter(";"));
        assertFalse(new Delimiter(";").equals(new Delimiter(".")));
    }

}