package calculator;

import calculator.enums.EMathOperationsConstans;
import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;

import static calculator.model.CurrentOperation.*;

public class MathOperationExecute {




public static InterfaceMathOperation execute(){
    InterfaceMathOperation<?,RealNumber,?> iMathOperation;

//    switch (getMathOperation()){
//        case SUM: iMathOperation=RealNumbersOperations::realNumbersOperation;
//       //execute2((firstElement, mathOperation, secondElement) -> RealNumbersOperations.realNumbersOperation((RealNumber) firstElement, mathOperation, (RealNumber)secondElement));
//        return iMathOperation;
//            break;
//        case SUBTRACTION: break;
//        case MULTIPLICATION: break;
//        case DIVISION: break;
//        case POW: break;
//        case SQR: break;
//        default:
//            throw new IllegalStateException("Unexpected value: " + getMathOperation());
    }
}


    public static void execute2(InterfaceMathOperation function){
       function.execute(getFirstMathObject(),getMathOperation(),getSecondMathObject());
    }
}
