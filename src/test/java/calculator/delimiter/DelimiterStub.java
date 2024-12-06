package calculator.delimiter;

import java.util.List;

public class DelimiterStub extends Delimiter {
    private List<String> testValue;

    public void setTestValue(List<String> testValue) {
        this.testValue = testValue;
    }

    @Override
    public List<String> split(String line) {
        return testValue;
    }
}
