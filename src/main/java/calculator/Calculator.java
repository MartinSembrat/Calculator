package calculator;

import calculator.mathObjectsClass.MathObject;
import static calculator.controler.MathOperationExecute.execute;
import static calculator.controler.CalculatorTeminate.calculatorTerminateMethod;
import static calculator.controler.CheckDataType.convertStringToMathematicalObject;
import static calculator.controler.CheckMathObjectPossibilities.setMathObjectToCurrentOperationClass;
import static calculator.controler.DataReader.readDataFromConsole;
import static calculator.controler.SelectAndPrintPossibleMathOperationAndSecondObjectType.checkAndPrintSecondMathematicalObjectPossibility;
import static calculator.controler.SelectAndPrintPossibleMathOperationAndSecondObjectType.selectPrintAndSetPossibleMathOperation;
import static calculator.enums.EMathOperationsConstants.SQRT;
import static calculator.model.CurrentOperation.*;

/**
 @author Martin Sembrat
 */
public class Calculator {
    public static void main(String[] args) {

        do {
            System.out.print("\n" +
                    "You have launched the calculator application \n" +
                    "Enter the first input in one of the following forms: \n" +
                    "Real number (allowed fractional form separated by a comma) \n" +
                    "*Vector in the form [x, y, ...] (up to 4 components)\n" +
                    "*Matrix in the form [a, b, ..], [c, d, ...], ... (the maximum size is 4x4, rows has to be of equal size ) \n");


            //receiving fist math object
            MathObject firstMathObject;
            do {
                firstMathObject = convertStringToMathematicalObject(readDataFromConsole());
            } while (!setMathObjectToCurrentOperationClass(firstMathObject));

            //check, print and set to CurrentOperation Class possible math operations
            selectPrintAndSetPossibleMathOperation();

            //check possible type of second object
            checkAndPrintSecondMathematicalObjectPossibility();

            //receiving second math object
            MathObject secondMathObject;
            do {
                if (getMathOperation().equals(SQRT)){break;}
                //can be null
                secondMathObject = convertStringToMathematicalObject(readDataFromConsole());
                //validation if object is not null and if is in line with requirements
            } while (!setMathObjectToCurrentOperationClass(secondMathObject));


            System.out.println("first object "+getFirstMathObject());
            System.out.println("sec object "+getSecondMathObject());
            //execute operation based on CurrentOperation class
            execute();
            System.out.println("Result: "+getResult());

            //clean CurrentOperation state
            cleanUpCurrentOperation();

        }while (calculatorTerminateMethod());
    }
}

