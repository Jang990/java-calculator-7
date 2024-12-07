package calculator;

import calculator.io.InputReader;
import calculator.io.OutputPrinter;

public class MyCalculatorApp {
    private final InputReader reader;
    private final OutputPrinter printer;
    private final Calculator calculator;
    private final String RESULT_TEMPLATE = "결과 : %d";

    public MyCalculatorApp(InputReader reader, OutputPrinter printer, Calculator calculator) {
        this.reader = reader;
        this.printer = printer;
        this.calculator = calculator;
    }

    public void run() {
        String input = reader.read();
        int result = calculator.sum(input);
        printer.print(RESULT_TEMPLATE.formatted(result));
    }
}
