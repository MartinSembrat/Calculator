package calculator.mathOperations;

import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;
import calculator.mathObjectsClass.VectorAsTable;
import org.junit.jupiter.api.Test;

import static calculator.mathOperations.VectorOperations.*;
import static calculator.currentState.CurrentOperation.setFirstMathObject;
import static calculator.currentState.CurrentOperation.setSecondMathObject;
import static org.junit.jupiter.api.Assertions.*;

class VectorOperationsTest {

    private VectorAsTable vector1 = new VectorAsTable(new float[][]{{7},{2},{92}});
    private VectorAsTable vector2= new VectorAsTable(new float[][]{{2},{0,},{9}});
    private VectorAsTable vectorResult;

    @Test
    void addVectorAsTableTest() {
        vectorResult= new VectorAsTable(new float[][]{{9},{2},{101}});
        setFirstMathObject(vector1);
        setSecondMathObject(vector2);
        assertEquals(vectorResult, addVectorAsTable());
        try{
            setFirstMathObject(new VectorAsTable(new float[][]{{12},{0},{-15}}));
            setSecondMathObject(new VectorAsTable(new float[][]{{12},{-15}}));
            addVectorAsTable();
            fail("Exception wasn't thrown!");
        }catch (IllegalArgumentException exception) {
            assertEquals("first vector elements numbers is not equal to other vector elements numbers", exception.getMessage());
        }
    }

    @Test
    void subtractVectorAsTableTest() {
        vectorResult= new VectorAsTable(new float[][]{{5},{2},{83}});
        setFirstMathObject(vector1);
        setSecondMathObject(vector2);
        assertEquals(vectorResult, subtractVectorAsTable());
        try{
            setFirstMathObject(new VectorAsTable(new float[][]{{12},{0},{-15}}));
            setSecondMathObject(new VectorAsTable(new float[][]{{12},{-15}}));
            subtractVectorAsTable();
            fail("Exception wasn't thrown!");
        }catch (IllegalArgumentException exception) {
            assertEquals("first vector elements numbers is not equal to other vector elements numbers", exception.getMessage());
        }
    }

    @Test
    void multiplyMatrixVectorTest() {
        VectorAsTable vectorResult= new VectorAsTable(new float[][]{{327},{484},{315}});
        Matrix matrix = new Matrix(new float[][]{{7, 1, 3}, {2, 5, 5},{9, 34, 2}});
        setFirstMathObject(matrix);
        setSecondMathObject(vector1);
        assertEquals(vectorResult, multiplyMatrixVector());
        try{
            setFirstMathObject(new Matrix(new float[][]{{12},{-15}}));
            setSecondMathObject(new VectorAsTable(new float[][]{{12},{0},{-15}}));
            multiplyMatrixVector();
            fail("Exception wasn't thrown!");
        }catch (IllegalArgumentException exception) {
            assertEquals("number of columns of first matrix is not equal to rows of second matrix, can not multiply", exception.getMessage());
        }
    }

    @Test
    void multiplyVectorMatrixTest() {
        Matrix matrixResult= new Matrix(new float[][]{{49,7,21},{14,2,6},{644,92,276}});
        Matrix matrix = new Matrix(new float[][]{{7, 1, 3}});
        setFirstMathObject(vector1);
        setSecondMathObject(matrix);
        assertEquals(matrixResult, VectorOperations.multiplyVectorMatrix());
        try{
            setFirstMathObject(new VectorAsTable(new float[][]{{12},{0},{-15}}));
            setSecondMathObject(new Matrix(new float[][]{{12},{-15}}));
            multiplyVectorMatrix();
            fail("Exception wasn't thrown!");
        }catch (IllegalArgumentException exception) {
            assertEquals("number of columns of this matrix is not equal to rows of second matrix, can not multiply", exception.getMessage());
        }
    }

    @Test
    void vectorRealNumbersMultiplierTest() {
        VectorAsTable matrixResult= new VectorAsTable (new float[][]{{70},{20},{920}});
        RealNumber realNumber = new RealNumber(10);
        setFirstMathObject(vector1);
        setSecondMathObject(realNumber);
        assertEquals(matrixResult, VectorOperations.vectorRealNumbersMultiplier());
    }

    @Test
    void realNumbersVectorMultiplierTest() {
        VectorAsTable matrixResult= new VectorAsTable (new float[][]{{70},{20},{920}});
        RealNumber realNumber = new RealNumber(10);
        setFirstMathObject(realNumber);
        setSecondMathObject(vector1);
        assertEquals(matrixResult, VectorOperations.realNumbersVectorMultiplier());
    }
}