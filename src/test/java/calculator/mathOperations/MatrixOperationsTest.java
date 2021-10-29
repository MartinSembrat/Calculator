package calculator.mathOperations;

import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;
import org.junit.jupiter.api.*;
import static calculator.model.CurrentOperation.*;
import static org.junit.jupiter.api.Assertions.*;

class MatrixOperationsTest {

    private Matrix matrix1 = new Matrix(new float[][]{{7, 1, 3}, {2, 5, 5},{9, 34, 2}});
    private Matrix matrix2= new Matrix(new float[][]{{2, 2, 2}, {0, 0, 0},{9, 1, 10}});
    private RealNumber realNumber= new RealNumber(15);
    private Matrix matrixResult;

    @Test
    void matrixMultiplierByNumber() {
        matrixResult= new Matrix(new float[][]{{105, 15, 45},{30, 75, 75},{135, 510, 30}});
        setFirstMathObject(matrix1);
        setSecondMathObject(realNumber);
        assertEquals(matrixResult, MatrixOperations.matrixMultiplierByNumber());
    }

    @Test
    void numberMatrixMultiplier() {
        matrixResult= new Matrix(new float[][]{{105, 15, 45},{30, 75, 75},{135, 510, 30}});
        setFirstMathObject(realNumber);
        setSecondMathObject(matrix1);
        assertEquals(matrixResult, MatrixOperations.numberMatrixMultiplier());
    }

    @Test
    void multiplyMatrix() {
        matrixResult= new Matrix(new float[][]{{41, 17, 44},{49, 9, 54},{36, 20, 38}});
        setFirstMathObject(matrix1);
        setSecondMathObject(matrix2);
        assertEquals(matrixResult, MatrixOperations.multiplyMatrix());
    }

    @Test
    void addMatrix() {
        matrixResult= new Matrix(new float[][]{{9, 3, 5},{2, 5, 5},{18, 35, 12}});
        setFirstMathObject(matrix1);
        setSecondMathObject(matrix2);
        assertEquals(matrixResult, MatrixOperations.addMatrix());
    }

    @Test
    void subtractMatrix() {
        matrixResult= new Matrix(new float[][]{{5, -1, 1},{2, 5, 5},{0, 33, -8}});
        setFirstMathObject(matrix1);
        setSecondMathObject(matrix2);
        assertEquals(matrixResult, MatrixOperations.subtractMatrix());
    }
}