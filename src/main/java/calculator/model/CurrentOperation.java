package calculator.model;

import calculator.enums.EMathObjectType;
import calculator.enums.EMathOperationsConstans;
import calculator.mathObjectsClass.MathObject;

import java.util.Collection;
import java.util.EnumSet;

public class CurrentOperation {
    private static EMathObjectType firstObjectEnum;
    private static EMathObjectType secondObjectEnum;
    private static EMathOperationsConstans mathOperation;
    private static EnumSet<EMathObjectType> mathObjectTypes = EnumSet.noneOf(EMathObjectType.class);
    private static MathObject firstMathObject;
    private static MathObject secondMathObject;
    private static MathObject result;

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

    public static EnumSet<EMathObjectType> getMathObjectTypes() {
        return mathObjectTypes;
    }

    public static void addMathObjectTypes(Collection<EMathObjectType> eMathObjectTypes) {
        CurrentOperation.mathObjectTypes.addAll( eMathObjectTypes);
    }
    public static void addMathObjectTypes(EMathObjectType eMathObjectTypes) {
        CurrentOperation.mathObjectTypes.add(eMathObjectTypes);
    }

    public static MathObject getFirstMathObject() {
        return firstMathObject;
    }

    public static void setFirstMathObject(MathObject firstMathObject) {
        CurrentOperation.firstMathObject = firstMathObject;
    }

    public static MathObject getSecondMathObject() {
        return secondMathObject;
    }

    public static void setSecondMathObject(MathObject secondMathObject) {
        CurrentOperation.secondMathObject = secondMathObject;
    }

    public static MathObject getResult() {
        return result;
    }

    public static void setResult(MathObject result) {
        CurrentOperation.result = result;
    }

    public static void cleanUpCurrentOperation() {
        firstObjectEnum = null;
        secondObjectEnum = null;
        mathOperation = null;
        mathObjectTypes = EnumSet.noneOf(EMathObjectType.class);
        firstMathObject = null;
        secondMathObject = null;
        result = null;
    }
}
