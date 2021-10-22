package calculator.mathOperations;

import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.VectorAsTable;

import static calculator.model.CurrentOperation.getFirstMathObject;
import static calculator.model.CurrentOperation.getSecondMathObject;

public class VectorOperations {


    public static VectorAsTable addVectorAsTable() {
        if (((VectorAsTable)getFirstMathObject()).getRowsNumber() != (((VectorAsTable)getSecondMathObject()).getRowsNumber())) {
            throw new IllegalArgumentException("first vector elements numbers is not equal to other vector elements numbers");
        } else {
            int rows = ((VectorAsTable)getFirstMathObject()).getRowsNumber();
            int columns = ((VectorAsTable)getFirstMathObject()).getColumnsNumber();
            float[][] result = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = ((VectorAsTable)getFirstMathObject()).getValue()[i][j] + ((VectorAsTable)getSecondMathObject()).getValue()[i][j];
                }
            }
            return new VectorAsTable(result);
        }
    }
    public static VectorAsTable subtractVectorAsTable() {
        if (((VectorAsTable)getFirstMathObject()).getRowsNumber() != (((VectorAsTable)getSecondMathObject()).getRowsNumber())) {
            throw new IllegalArgumentException("first vector elements numbers is not equal to other elements plane");
        } else {
            int rows =((VectorAsTable)getFirstMathObject()).getRowsNumber();
            int columns = ((VectorAsTable)getFirstMathObject()).getColumnsNumber();
            float[][] result = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = ((VectorAsTable)getFirstMathObject()).getValue()[i][j] - ((VectorAsTable)getSecondMathObject()).getValue()[i][j];
                }
            }
            return new VectorAsTable(result);
        }
    }

    //TODO correct logic
    public static VectorAsTable multiplyMatrixVector() {
        if (((Matrix)getFirstMathObject()).getColumnsNumber() != ((VectorAsTable)getSecondMathObject()).getRowsNumber()) {
            throw new IllegalArgumentException("number of columns of first matrix is not equal to rows of second matrix, can not multiply");
        } else {
            float[][] result = new float[((Matrix)getFirstMathObject()).getRowsNumber()][((VectorAsTable)getSecondMathObject()).getColumnsNumber()];
            float sum = 0;
            for (int i = 0; i < ((Matrix)getFirstMathObject()).getRowsNumber(); i++) {
                for (int j = 0; j < ((VectorAsTable)getSecondMathObject()).getColumnsNumber(); j++) {
                    for (int k = 0; k < ((VectorAsTable)getSecondMathObject()).getRowsNumber(); k++) {
                        sum = sum + ((Matrix)getFirstMathObject()).getValue()[i][k] * ((VectorAsTable)getSecondMathObject()).getValue()[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new VectorAsTable(result);
        }
    }

    //TODO correct logic
    public static VectorAsTable multiplyVectorMatrix() {
        if (((Matrix)getSecondMathObject()).getRowsNumber() != ((VectorAsTable)getFirstMathObject()).getColumnsNumber()) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to rows of second matrix, can not multiply");
        } else {
            float[][] result = new float[((Matrix)getSecondMathObject()).getRowsNumber()][((VectorAsTable)getFirstMathObject()).getColumnsNumber()];
            float sum = 0;
            for (int i = 0; i < ((Matrix)getSecondMathObject()).getRowsNumber(); i++) {
                for (int j = 0; j < ((VectorAsTable)getFirstMathObject()).getColumnsNumber(); j++) {
                    for (int k = 0; k < ((VectorAsTable)getFirstMathObject()).getRowsNumber(); k++) {
                        sum = sum + ((Matrix)getSecondMathObject()).getValue()[i][k] * ((VectorAsTable)getFirstMathObject()).getValue()[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new VectorAsTable(result);
        }
    }

    public static VectorAsTable vectorRealNumbersMultiplier() {
        int rows = ((VectorAsTable)getFirstMathObject()).getRowsNumber();
        int columns = ((VectorAsTable)getFirstMathObject()).getColumnsNumber();
        float[][] result = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (((VectorAsTable)getFirstMathObject()).getValue()[i][j] * (float)getSecondMathObject().getValue());
            }
        }
        return new VectorAsTable(result);
    }

    public static VectorAsTable realNumbersVectorMultiplier() {
        int rows = ((VectorAsTable)getSecondMathObject()).getRowsNumber();
        int columns = ((VectorAsTable)getSecondMathObject()).getColumnsNumber();
        float[][] result = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (((VectorAsTable)getSecondMathObject()).getValue()[i][j] * (float)getFirstMathObject().getValue());
            }
        }
        return new VectorAsTable(result);
    }
}
