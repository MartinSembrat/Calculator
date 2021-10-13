package calculator.controler;

import static calculator.controler.DataReader.readDataFromConsole;

public class CalculatorTeminate {
    public static boolean calculatorTerminateMethod() {
        boolean repeat = false;
        boolean doNotTerminateCalculator = false;
        do {
            System.out.println("Whether to progress next action? yes/no");
            String restartCalculator = readDataFromConsole().toLowerCase();
            if (restartCalculator.equals("yes")) {
                doNotTerminateCalculator = true;
                System.out.println("Next mathematical operation");
            } else if (restartCalculator.equals("no")) {
                System.out.println("Terminate program");
            } else {
                repeat = true;
            }
        } while (repeat);
        return doNotTerminateCalculator;
    }
}

