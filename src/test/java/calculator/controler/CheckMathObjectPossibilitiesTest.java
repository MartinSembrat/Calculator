package calculator.controler;

import calculator.enums.EMathObjectType;
import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.VectorAsTable;
import org.junit.jupiter.api.Test;

import static calculator.controler.CheckMathObjectPossibilities.secondMathObjectValidate;
import static calculator.controler.CheckMathObjectPossibilities.setMathObjectToCurrentOperationClass;
import static calculator.enums.EMathObjectType.MATRIX;
import static calculator.currentState.CurrentOperation.*;
import static org.junit.jupiter.api.Assertions.*;

class CheckMathObjectPossibilitiesTest {

    @Test
    void setMathObjectToCurrentOperationClassTest() {
        assertFalse(setMathObjectToCurrentOperationClass(null));
        setFirstObjectEnum(null);
        assertTrue(setMathObjectToCurrentOperationClass(new Matrix(new float[][]{{5, -1, 1},{2, 5, 5},{0, 33, -8}})));
        assertEquals(getFirstMathObject(), new Matrix(new float[][]{{5, -1, 1},{2, 5, 5},{0, 33, -8}}));
        addMathObjectTypes(MATRIX);
        assertFalse(setMathObjectToCurrentOperationClass(new VectorAsTable(new float[][]{{0},{0}})));
        assertTrue(setMathObjectToCurrentOperationClass(new Matrix(new float[][]{{0},{0}})));
        assertEquals(getSecondMathObject(), new Matrix(new float[][]{{0},{0}}));
    }

    @Test
    void secondMathObjectValidateTest() {
        getMathObjectTypes().forEach(System.out::println);
        addMathObjectTypes(MATRIX);
        setSecondObjectEnum(EMathObjectType.VECTOR);
        assertFalse(secondMathObjectValidate());
        setSecondObjectEnum(MATRIX);
        assertTrue(secondMathObjectValidate());
    }
}