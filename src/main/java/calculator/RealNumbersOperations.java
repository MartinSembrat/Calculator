package calculator;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class RealNumbersOperations {

    public static void RealNumbersOp(float firstElement, float secondElement, String z) {
        switch (z) {
            case MathOperationsConstans.SUM:
                System.out.println("Suma " + (firstElement + secondElement));
                break;
            case MathOperationsConstans.SUBTRACTION:
                System.out.println("Różnica " + (firstElement - secondElement));
                break;
            case MathOperationsConstans.MULTIPLICATION:
                System.out.println("Iloczyn " + firstElement * secondElement);
                break;
            case MathOperationsConstans.DIVISION:
                System.out.println("Iloraz " + firstElement / secondElement);
                break;
            case MathOperationsConstans.POW:
                System.out.println("Potęga " + pow(firstElement, secondElement));
                break;
            case MathOperationsConstans.SQR:
                System.out.println("Pierwiastek kwadratowy " + sqrt(firstElement));
                break;
        }
    }
}
