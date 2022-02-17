package calculator.controler;

import calculator.mathOperations.InterfaceMathOperation;
import calculator.mathOperations.MatrixOperations;
import calculator.mathOperations.RealNumbersOperations;
import calculator.mathOperations.VectorOperations;
import static calculator.enums.EMathObjectType.*;
import static calculator.currentState.CurrentOperation.*;

public class MathOperationExecute {

public static InterfaceMathOperation mathOperationprovider(){
    InterfaceMathOperation iMathOperation= null;

    switch (getMathOperation()){
        case SUM:
            if (getFirstObjectEnum().equals(REALNUMBER) && getSecondObjectEnum().equals(REALNUMBER))
            {iMathOperation= RealNumbersOperations::realNumbersOperation;
            } else if (getFirstObjectEnum().equals(MATRIX) && getSecondObjectEnum().equals(MATRIX)){
                iMathOperation= MatrixOperations::addMatrix;
            }else if (getFirstObjectEnum().equals(VECTOR) && getSecondObjectEnum().equals(VECTOR)){
                iMathOperation= VectorOperations::addVectorAsTable;
            }break;
        case SUBTRACTION:
            if (getFirstObjectEnum().equals(REALNUMBER) && getSecondObjectEnum().equals(REALNUMBER))
            {iMathOperation=RealNumbersOperations::realNumbersOperation;
            } else if (getFirstObjectEnum().equals(MATRIX) && getSecondObjectEnum().equals(MATRIX)){
                iMathOperation=MatrixOperations::subtractMatrix;
            }else if (getFirstObjectEnum().equals(VECTOR) && getSecondObjectEnum().equals(VECTOR)){
                iMathOperation=VectorOperations::subtractVectorAsTable;
            }break;
        case MULTIPLICATION:
            if (getFirstObjectEnum().equals(REALNUMBER) && getSecondObjectEnum().equals(REALNUMBER))
            {iMathOperation=RealNumbersOperations::realNumbersOperation;
            } else if (getFirstObjectEnum().equals(MATRIX) && getSecondObjectEnum().equals(MATRIX)){
                iMathOperation=MatrixOperations::multiplyMatrix;
            }else if (getFirstObjectEnum().equals(MATRIX) && getSecondObjectEnum().equals(VECTOR)){
                iMathOperation=VectorOperations::multiplyMatrixVector;
            }else if (getFirstObjectEnum().equals(VECTOR) && getSecondObjectEnum().equals(MATRIX)){
                 iMathOperation=VectorOperations::multiplyVectorMatrix;
            }else if (getFirstObjectEnum().equals(VECTOR) && getSecondObjectEnum().equals(REALNUMBER)){
                iMathOperation=VectorOperations::vectorRealNumbersMultiplier;
            }else if (getFirstObjectEnum().equals(REALNUMBER) && getSecondObjectEnum().equals(VECTOR)){
                iMathOperation=VectorOperations::realNumbersVectorMultiplier;
            }else if (getFirstObjectEnum().equals(MATRIX) && getSecondObjectEnum().equals(REALNUMBER)){
                iMathOperation=MatrixOperations::matrixMultiplierByNumber;
            }else if (getFirstObjectEnum().equals(REALNUMBER) && getSecondObjectEnum().equals(MATRIX)){
                iMathOperation=MatrixOperations::numberMatrixMultiplier;
            }break;
        case DIVISION:
        case POW:
            if (getFirstObjectEnum().equals(REALNUMBER) && getSecondObjectEnum().equals(REALNUMBER))
            {iMathOperation=RealNumbersOperations::realNumbersOperation;} break;
        case SQRT:
            if (getFirstObjectEnum().equals(REALNUMBER))
            {iMathOperation=RealNumbersOperations::realNumbersOperation;} break;
        default:
            throw new IllegalStateException("Unexpected value: " + getMathOperation());
    } return iMathOperation;
}

    public static void execute(){
       setResult(mathOperationprovider().execute());
    }
}
