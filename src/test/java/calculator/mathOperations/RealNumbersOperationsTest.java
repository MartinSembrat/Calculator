package calculator.mathOperations;

import calculator.mathObjectsClass.RealNumber;
import org.junit.jupiter.api.Test;

import static calculator.enums.EMathOperationsConstans.*;
import static calculator.model.CurrentOperation.*;
import static org.junit.jupiter.api.Assertions.*;

class RealNumbersOperationsTest {
    @Test
    void realNumbersOperation() {
        setFirstMathObject(new RealNumber(99));
        setSecondMathObject(new RealNumber(2));
        setMathOperation(SUM);
        assertEquals(101, RealNumbersOperations.realNumbersOperation().getValue());
        setMathOperation(SUBTRACTION);
        assertEquals(97, RealNumbersOperations.realNumbersOperation().getValue());
        setMathOperation(MULTIPLICATION);
        assertEquals(198, RealNumbersOperations.realNumbersOperation().getValue());
        setMathOperation(DIVISION);
        assertEquals(49.5f,RealNumbersOperations.realNumbersOperation().getValue());
        setMathOperation(POW);
        assertEquals(9801, RealNumbersOperations.realNumbersOperation().getValue());
        setMathOperation(SQRT);
        assertEquals(Math.sqrt(99), RealNumbersOperations.realNumbersOperation().getValue(),0.1);
    }
}