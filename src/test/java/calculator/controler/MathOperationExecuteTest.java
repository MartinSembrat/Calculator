package calculator.controler;

import calculator.mathObjectsClass.Matrix;
import calculator.mathOperations.InterfaceMathOperation;
import calculator.mathOperations.MatrixOperations;
import org.junit.jupiter.api.Test;

import static calculator.controler.MathOperationExecute.mathOperationprovider;
import static calculator.enums.EMathObjectType.MATRIX;
import static calculator.enums.EMathOperationsConstants.SUM;
import static calculator.currentState.CurrentOperation.*;
import static org.junit.jupiter.api.Assertions.*;

class MathOperationExecuteTest {

    @Test
    void mathOperationproviderTest() {
        setFirstObjectEnum(MATRIX);
        setMathOperation(SUM);
        setSecondObjectEnum(MATRIX);
        InterfaceMathOperation iMathOperation= MatrixOperations::addMatrix;
        setFirstMathObject(new Matrix(new float[][]{{12},{-15}}));
        setSecondMathObject(new Matrix(new float[][]{{12},{-15}}));
        assertEquals(iMathOperation.execute(),mathOperationprovider().execute());
    }
}