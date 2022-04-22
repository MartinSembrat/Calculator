package calculator.mathOperations;

import calculator.mathObjectsClass.RealNumber;
import static calculator.currentState.CurrentOperation.*;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class RealNumbersOperations {

    public static RealNumber realNumbersOperation() {
        float result;
        switch (getMathOperation()) {
            case SUM:
                result =((RealNumber)getFirstMathObject()).getValue() + ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Sum " + result);
                break;
            case SUBTRACTION:
                result=((RealNumber)getFirstMathObject()).getValue() - ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Subtract " + result);
                break;
            case MULTIPLICATION:
                result = ((RealNumber)getFirstMathObject()).getValue() * ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Multiply " + result);
                break;
            case DIVISION:
                result = ((RealNumber)getFirstMathObject()).getValue() / ((RealNumber)getSecondMathObject()).getValue();
                System.out.println("Divide " + result);
                break;
            case POW:
                result = (float) pow(((RealNumber)getFirstMathObject()).getValue(), ((RealNumber)getSecondMathObject()).getValue());
                System.out.println("Power result " + result);
                break;
            case SQRT:
                result=  (float) sqrt(((RealNumber)getFirstMathObject()).getValue());
                System.out.println("Square root " +result );
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getMathOperation());
        }
        return new RealNumber(result);
    }
}
