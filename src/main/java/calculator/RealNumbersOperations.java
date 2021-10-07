package calculator;

import calculator.enums.EMathOperationsConstans;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class RealNumbersOperations {

    public static float RealNumbersOperation(float firstElement, float secondElement, EMathOperationsConstans mathOperation) {
        float result;
        switch (mathOperation) {
            case SUM:
                result =firstElement + secondElement;
                System.out.println("Suma " + result);
                break;
            case SUBTRACTION:
                result=firstElement - secondElement;
                System.out.println("Różnica " + result);
                break;
            case MULTIPLICATION:
                result = firstElement * secondElement;
                System.out.println("Iloczyn " + result);
                break;
            case DIVISION:
                result = firstElement / secondElement;
                System.out.println("Iloraz " + result);
                break;
            case POW:
                result = (float) pow(firstElement, secondElement);
                System.out.println("Potęga " + result);
                break;
            case SQR:
                result= (float) sqrt(firstElement);
                System.out.println("Pierwiastek kwadratowy " +result );
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mathOperation);
        }
        return result;
    }
}
