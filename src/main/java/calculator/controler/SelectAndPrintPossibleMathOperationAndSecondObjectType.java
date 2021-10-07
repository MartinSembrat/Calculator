package calculator.controler;

import calculator.enums.EMathObjectType;

import java.util.Arrays;

import static calculator.model.CurrentOperation.*;
import static calculator.controler.DataReader.readDataFromConsole;
import static calculator.enums.EMathObjectType.*;
import static calculator.enums.EMathOperationsConstans.*;


public class SelectAndPrintPossibleMathOperationAndSecondObjectType {


    public static void selectPrintAndSetPossibleMathOperation() {

        if (getFirstObjectEnum() == null) {
            System.out.println("First math object missing");
        }
        System.out.println("Choose mathematical operation from below:");
        switch (getFirstObjectEnum()) {
            case REALNUMBER:
                System.out.println(SUM + "\n" + SUBTRACTION + "\n" + MULTIPLICATION + "\n" + DIVISION + "\n" + POW + "\n" + SQR);
                break;
            case VECTOR:
            case MATRIX:
                System.out.println(SUM + "\n" + SUBTRACTION + "\n" + MULTIPLICATION);
                break;
            default:
                System.out.println("first math object is incorrect");
        }

        boolean repeat = false;
        do {
            switch (readDataFromConsole().toUpperCase()) {
                case "SUM":
                    setMathOperation(SUM);
                    break;
                case "SUBTRACTION":
                    setMathOperation(SUBTRACTION);
                    break;
                case "MULTIPLICATION":
                    setMathOperation(MULTIPLICATION);
                    break;
                case "DIVISION":
                    if (getFirstObjectEnum().equals(REALNUMBER)) {
                        setMathOperation(DIVISION);
                    } else {
                        System.out.println("Incorrect operation");
                        repeat = true;
                    }
                    break;
                case "POW":
                    if (getFirstObjectEnum().equals(REALNUMBER)) {
                        setMathOperation(POW);
                    } else {
                        System.out.println("Incorrect operation");
                        repeat = true;
                    }
                    break;
                case "SQR":
                    if (getFirstObjectEnum().equals(REALNUMBER)) {
                        setMathOperation(SQR);
                    } else {
                        System.out.println("Incorrect operation");
                        repeat = true;
                    }
                    break;
                default:
                    System.out.println("Incorrect data, try again");
                    repeat = true;
            }
        } while (repeat);
    }

    public static void checkAndPrintSecondMathematicalObjectPossibility() {
        //TODO add SQR execute
        if (getMathOperation().equals(SQR)) {
            return;
        } else if (getFirstObjectEnum().equals(null) || getMathOperation().equals(null)) {
            System.out.println("First math object or math operation missing");
            return;
        }
        switch (getMathOperation()) {
            case SUM:
            case SUBTRACTION:
                if (getFirstObjectEnum().equals(REALNUMBER)) {
                    System.out.println("Enter a real number");
                    addMathObjectTypes(REALNUMBER);
                } else if (getFirstObjectEnum().equals(VECTOR)) {
                    System.out.println("Enter a vector");
                    addMathObjectTypes(VECTOR);
                } else if (getFirstObjectEnum().equals(MATRIX)) {
                    System.out.println("Enter a matrix");
                    addMathObjectTypes(MATRIX);
                }
                break;
            case MULTIPLICATION:
                if (getFirstObjectEnum().equals(REALNUMBER) || getFirstObjectEnum().equals(MATRIX)) {
                    System.out.println("Enter a real number, vector, matrix");
                    addMathObjectTypes(Arrays.asList(new EMathObjectType[]{REALNUMBER, VECTOR, MATRIX}));
                } else if (getFirstObjectEnum().equals(VECTOR)) {
                    System.out.println("Enter a real number or matrix");
                    addMathObjectTypes(Arrays.asList(new EMathObjectType[]{REALNUMBER, MATRIX}));
                }
                break;
            case DIVISION:
            case POW:
                if (getFirstObjectEnum().equals(REALNUMBER)) {
                    System.out.println("Enter a real number");
                    addMathObjectTypes(REALNUMBER);
                }
                break;
        }
    }


}