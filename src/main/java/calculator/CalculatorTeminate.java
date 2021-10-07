package calculator;

import static calculator.controler.DataReader.readDataFromConsole;

public class CalculatorTeminate {
    public static boolean calculatorTerminateMethod() {
        boolean stop = false;
        boolean terminateCalculator = false;
        do {
            System.out.println("Whether to progress next action? yes/no");
            String restartCalculator = readDataFromConsole().toLowerCase();
            if (restartCalculator.equals("yes")) {
                terminateCalculator = true;
                System.out.println("Next mathematical operation");
            } else if (restartCalculator.equals("no")) {
                System.out.println("Terminate program");
            } else {
                stop = true;
            }
        } while (!stop);     return terminateCalculator;
    }
}

