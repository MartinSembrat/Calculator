package calculator.controler;

import calculator.mathObjectsClass.MathObject;
import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;
import calculator.mathObjectsClass.VectorAsTable;

import static calculator.model.CurrentOperation.*;
import static calculator.enums.EMathObjectType.*;

public class CheckMathObjectPossibilities {

    public static boolean setMathObjectToCurrentOperationClass(MathObject object) {

        if (getFirstObjectEnum() == null) {
            if (object instanceof RealNumber) {
                setFirstObjectEnum(REALNUMBER);
            } else if (object instanceof VectorAsTable) {
                setFirstObjectEnum(VECTOR);
            } else if (object instanceof Matrix) {
                setFirstObjectEnum(MATRIX);
            }  setFirstMathObject(object); return true;
        } else {
            if (object instanceof RealNumber) {
                setSecondObjectEnum(REALNUMBER);
            } else if (object instanceof VectorAsTable) {
                setSecondObjectEnum(VECTOR);
            } else if (object instanceof Matrix) {
                setSecondObjectEnum(MATRIX);
            }setSecondMathObject(object); return secondMathObjectValidate();
        }
    }
    //check if object is is line with requirements
    static boolean secondMathObjectValidate() {
        return getMathObjectTypes().contains(getSecondObjectEnum());}
    }
