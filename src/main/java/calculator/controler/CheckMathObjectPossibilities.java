package calculator.controler;

import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;
import calculator.mathObjectsClass.VectorAsTable;

import static calculator.model.CurrentOperation.*;
import static calculator.enums.EMathObjectType.*;

public class CheckMathObjectPossibilities {

    public static <T> boolean setMathObjectToCurrentOperationClass(T object) {

        if (getFirstObjectEnum() == null) {
            if (object instanceof RealNumber) {
                setFirstObjectEnum(REALNUMBER);
                setFirstMathObject(REALNUMBER);
            } else if (object instanceof VectorAsTable) {
                setFirstObjectEnum(VECTOR);
                setFirstMathObject(VECTOR);
            } else if (object instanceof Matrix) {
                setFirstObjectEnum(MATRIX);
                setFirstMathObject(MATRIX);
            } return true;

        } else {
            if (object instanceof RealNumber) {
                setSecondObjectEnum(REALNUMBER);
                setSecondMathObject(REALNUMBER);
            } else if (object instanceof VectorAsTable) {
                setSecondObjectEnum(VECTOR);
                setSecondMathObject(VECTOR);
            } else if (object instanceof Matrix) {
                setSecondObjectEnum(MATRIX);
                setSecondMathObject(MATRIX);
            } return secondMathObjectValidate();
        }
    }
    //check if object is is line with requirements
    static boolean secondMathObjectValidate() {
        return getEMathObjectTypes().contains(getSecondObjectEnum()) ? true : false;}
    }
