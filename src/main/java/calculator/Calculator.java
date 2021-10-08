package calculator;

import static calculator.controler.CalculatorTeminate.calculatorTerminateMethod;
import static calculator.controler.CheckDataType.convertStringToMathematicalObject;
import static calculator.controler.CheckMathObjectPossibilities.setMathObjectToCurrentOperationClass;
import static calculator.controler.DataReader.readDataFromConsole;
import static calculator.controler.SelectAndPrintPossibleMathOperationAndSecondObjectType.checkAndPrintSecondMathematicalObjectPossibility;
import static calculator.controler.SelectAndPrintPossibleMathOperationAndSecondObjectType.selectPrintAndSetPossibleMathOperation;
import static calculator.model.CurrentOperation.cleanUpCurrentOperation;

/**
 @author Martin Sembrat
 */
public class Calculator {
    public static void main(String[] args) {

        do {
            System.out.print("Uruchomiłeś aplikację kalkulator \n" +
                    "Wprowadz pierwsze dane wejściowe w jednej z poniższych postaci: \n" +
                    "*Liczba rzeczywista (dopuszczalna postać ułamkowa rozdzielona przecinkiem \n" +
                    "*Wektor w postaci [x,y,...] (maksymalnie 4 skadowe)\n" +
                    "*Macierz w postaci [a,b,..],[c,d,...],... (maksymalny rozmiar to 4x4) \n");


            //receiving fist math object
            Object firstMathObject;
            do {
                firstMathObject = convertStringToMathematicalObject(readDataFromConsole());
            } while (setMathObjectToCurrentOperationClass(firstMathObject));

            //check, print and set to CurrentOperation Class possible math operations
            selectPrintAndSetPossibleMathOperation();

            //check possible type of second object
            checkAndPrintSecondMathematicalObjectPossibility();

            //execute operation based on CurrentOperation class


            //clean CurrentOperation state
            cleanUpCurrentOperation();


        }while (calculatorTerminateMethod());
    }
}

