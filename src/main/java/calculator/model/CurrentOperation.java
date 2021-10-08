package calculator.model;

import calculator.enums.EMathObjectType;
import calculator.enums.EMathOperationsConstans;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CurrentOperation {
    private static EMathObjectType firstObjectEnum;
    private static EMathObjectType secondObjectEnum;
    private static EMathOperationsConstans mathOperation;
    private static Set<EMathObjectType> eMathObjectTypes = new HashSet();
    private static Object firstMathObject;
    private static Object secondMathObject;
    private static Object result;

    public static Object getFirstMathObject() {
        return firstMathObject;
    }

    public static void setFirstMathObject(Object firstMathObject) {
        CurrentOperation.firstMathObject = firstMathObject;
    }

    public static Object getSecondMathObject() {
        return secondMathObject;
    }

    public static void setSecondMathObject(Object secondMathObject) {
        CurrentOperation.secondMathObject = secondMathObject;
    }

    public static Set getEMathObjectTypes() {
        return eMathObjectTypes;
    }

    public static void addMathObjectTypes(Collection<EMathObjectType> eMathObjectType) {
        CurrentOperation.eMathObjectTypes.addAll(eMathObjectType) ;
    }

    public static void addMathObjectTypes(EMathObjectType eMathObjectType) {
        CurrentOperation.eMathObjectTypes.add(eMathObjectType) ;
    }

    public static EMathObjectType getFirstObjectEnum() {
        return firstObjectEnum;
    }

    public static void setFirstObjectEnum(EMathObjectType firstObjectEnum) {
        CurrentOperation.firstObjectEnum = firstObjectEnum;
    }

    public static EMathObjectType getSecondObjectEnum() {
        return secondObjectEnum;
    }

    public static void setSecondObjectEnum(EMathObjectType secondObjectEnum) {
        CurrentOperation.secondObjectEnum = secondObjectEnum;
    }

    public static EMathOperationsConstans getMathOperation() {
        return mathOperation;
    }

    public static void setMathOperation(EMathOperationsConstans mathOperation) {
        CurrentOperation.mathOperation = mathOperation;
    }

    public static void cleanUpCurrentOperation() {
        firstObjectEnum = null;
        secondObjectEnum = null;
        mathOperation = null;
        eMathObjectTypes = null;
        firstMathObject = null;
        secondMathObject = null;
        result = null;
    }
}
