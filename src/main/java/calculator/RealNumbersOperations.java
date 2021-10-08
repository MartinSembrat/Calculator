package calculator;

import calculator.enums.EMathOperationsConstans;
import calculator.mathObjectsClass.RealNumber;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class RealNumbersOperations {

    public static RealNumber realNumbersOperation(RealNumber firstElement, EMathOperationsConstans mathOperation, RealNumber secondElement) {
        float result;
        switch (mathOperation) {
            case SUM:
                result =firstElement.getRealNumber() + secondElement.getRealNumber();
                System.out.println("Suma " + result);
                break;
            case SUBTRACTION:
                result=firstElement.getRealNumber() - secondElement.getRealNumber();
                System.out.println("Różnica " + result);
                break;
            case MULTIPLICATION:
                result = firstElement.getRealNumber() * secondElement.getRealNumber();
                System.out.println("Iloczyn " + result);
                break;
            case DIVISION:
                result = firstElement.getRealNumber() / secondElement.getRealNumber();
                System.out.println("Iloraz " + result);
                break;
            case POW:
                result = (float) pow(firstElement.getRealNumber(), secondElement.getRealNumber());
                System.out.println("Potęga " + result);
                break;
            case SQR:
                result= (float) sqrt(firstElement.getRealNumber());
                System.out.println("Pierwiastek kwadratowy " +result );
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mathOperation);
        }
        return new RealNumber(result);
    }
}
