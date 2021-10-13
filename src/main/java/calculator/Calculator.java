package calculator;

import calculator.mathObjectsClass.MathObject;

import static calculator.controler.MathOperationExecute.execute;
import static calculator.controler.CalculatorTeminate.calculatorTerminateMethod;
import static calculator.controler.CheckDataType.convertStringToMathematicalObject;
import static calculator.controler.CheckMathObjectPossibilities.setMathObjectToCurrentOperationClass;
import static calculator.controler.DataReader.readDataFromConsole;
import static calculator.controler.SelectAndPrintPossibleMathOperationAndSecondObjectType.checkAndPrintSecondMathematicalObjectPossibility;
import static calculator.controler.SelectAndPrintPossibleMathOperationAndSecondObjectType.selectPrintAndSetPossibleMathOperation;
import static calculator.model.CurrentOperation.*;

/**
 @author Martin Sembrat
 */
public class Calculator {
    public static void main(String[] args) {

        do {
            System.out.print("Uruchomiłeś aplikację kalkulator \n" +
                    "Wprowadz pierwsze dane wejściowe w jednej z poniższych postaci: \n" +
                    "*Liczba rzeczywista (dopuszczalna postać ułamkowa rozdzielona przecinkiem \n" +
                    "*Wektor w postaci [x,y,...] (maksymalnie 4 składowe)\n" +
                    "*Macierz w postaci [a,b,..],[c,d,...],... (maksymalny rozmiar to 4x4) \n");


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
                //can be null
                secondMathObject = convertStringToMathematicalObject(readDataFromConsole());
                //validation if object is not null and if is in line with requirements
            } while (!setMathObjectToCurrentOperationClass(secondMathObject));


            System.out.println("first object "+getFirstMathObject());
            System.out.println("sec object "+getSecondMathObject());
            //execute operation based on CurrentOperation class
            execute();
            System.out.println(getResult());

            //clean CurrentOperation state
            cleanUpCurrentOperation();

        }while (calculatorTerminateMethod());
    }
}

