package calculator.mathOperations;

import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;
import calculator.mathObjectsClass.VectorAsTable;
import org.junit.jupiter.api.Test;

import static calculator.model.CurrentOperation.setFirstMathObject;
import static calculator.model.CurrentOperation.setSecondMathObject;
import static org.junit.jupiter.api.Assertions.*;

class VectorOperationsTest {

    private VectorAsTable vector1 = new VectorAsTable(new float[][]{{7},{2},{92}});
    private VectorAsTable vector2= new VectorAsTable(new float[][]{{2},{0,},{9}});
    private RealNumber realNumber= new RealNumber(2);
    private VectorAsTable vectorResult;

    @Test
    void addVectorAsTable() {
        vectorResult= new VectorAsTable(new float[][]{{9},{2},{101}});
        setFirstMathObject(vector1);
        setSecondMathObject(vector2);
        assertEquals(vectorResult, VectorOperations.addVectorAsTable());
    }

    @Test
    void subtractVectorAsTable() {
        vectorResult= new VectorAsTable(new float[][]{{5},{2},{83}});
        setFirstMathObject(vector1);
        setSecondMathObject(vector2);
        assertEquals(vectorResult, VectorOperations.subtractVectorAsTable());
    }

    @Test
    void multiplyMatrixVector() {
        VectorAsTable vectorResult= new VectorAsTable(new float[][]{{327},{484},{315}});
        Matrix matrix = new Matrix(new float[][]{{7, 1, 3}, {2, 5, 5},{9, 34, 2}});
        setFirstMathObject(matrix);
        setSecondMathObject(vector1);
        assertEquals(vectorResult, VectorOperations.multiplyMatrixVector());
    }

    @Test
    void multiplyVectorMatrix() {
        Matrix matrixResult= new Matrix(new float[][]{{49,7,21},{14,2,6},{644,92,276}});
        Matrix matrix = new Matrix(new float[][]{{7, 1, 3}});
        setFirstMathObject(vector1);
        setSecondMathObject(matrix);
        assertEquals(matrixResult, VectorOperations.multiplyVectorMatrix());
    }

    @Test
    void vectorRealNumbersMultiplier() {
        VectorAsTable matrixResult= new VectorAsTable (new float[][]{{70},{20},{920}});
        RealNumber realNumber = new RealNumber(10);
        setFirstMathObject(vector1);
        setSecondMathObject(realNumber);
        assertEquals(matrixResult, VectorOperations.vectorRealNumbersMultiplier());
    }

    @Test
    void realNumbersVectorMultiplier() {
        VectorAsTable matrixResult= new VectorAsTable (new float[][]{{70},{20},{920}});
        RealNumber realNumber = new RealNumber(10);
        setFirstMathObject(realNumber);
        setSecondMathObject(vector1);
        assertEquals(matrixResult, VectorOperations.realNumbersVectorMultiplier());
    }
}