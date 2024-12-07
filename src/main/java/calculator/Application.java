package calculator;

import calculator.delimiter.DelimiterReader;
import calculator.io.InputReader;
import calculator.io.OutputPrinter;
import calculator.numbers.PositiveNumbersReader;

public class Application {
    public static void main(String[] args) {
        myCalculatorApp().run();
    }

    public static InputReader inputReader() {
        return new InputReader();
    }

    public static OutputPrinter outputPrinter() {
        return new OutputPrinter();
    }

    public static DelimiterReader delimiterReader() {
        return new DelimiterReader();
    }

    public static PositiveNumbersReader positiveNumberReader() {
        return new PositiveNumbersReader();
    }

    public static Calculator calculator() {
        return new Calculator(delimiterReader(), positiveNumberReader());
    }

    public static MyCalculatorApp myCalculatorApp() {
        return new MyCalculatorApp(inputReader(), outputPrinter(), calculator());
    }
}
