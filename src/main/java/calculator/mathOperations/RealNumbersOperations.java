package calculator.mathOperations;

import calculator.mathObjectsClass.RealNumber;
import static calculator.model.CurrentOperation.*;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class RealNumbersOperations {

    public static RealNumber realNumbersOperation() {
        float result;
        switch (getMathOperation()) {
            case SUM:
                result =((RealNumber)getFirstMathObject()).getValue() + ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Suma " + result);
                break;
            case SUBTRACTION:
                result=((RealNumber)getFirstMathObject()).getValue() - ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Różnica " + result);
                break;
            case MULTIPLICATION:
                result = ((RealNumber)getFirstMathObject()).getValue() * ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Iloczyn " + result);
                break;
            case DIVISION:
                result = ((RealNumber)getFirstMathObject()).getValue() / ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Iloraz " + result);
                break;
            case POW:
                result = (float) pow(((RealNumber)getFirstMathObject()).getValue(), ((RealNumber)getSecondMathObject()).getValue());
                System.out.println("Potęga " + result);
                break;
            case SQRT:
                result=  (float) sqrt(((RealNumber)getFirstMathObject()).getValue());
                System.out.println("Pierwiastek kwadratowy " +result );
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getMathOperation());
        }
        return new RealNumber(result);
    }
}