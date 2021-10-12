package calculator.mathOperations;

import calculator.mathObjectsClass.Matrix;

import static calculator.model.CurrentOperation.*;

public class MatrixOperations {

    public static Matrix matrixMultiplierByNumber() {
        int rows = ((Matrix)getFirstMathObject()).getRowsNumber();
        int columns = ((Matrix)getFirstMathObject()).getColumnsNumber();
        float[][] result = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (((Matrix)getFirstMathObject()).getValue()[i][j]*(float)getSecondMathObject().getValue());
            }
        }
        return new Matrix(result);
    }

    public static Matrix numberMatrixMultiplier() {
        int rows = ((Matrix)getSecondMathObject()).getRowsNumber();
        int columns = ((Matrix)getSecondMathObject()).getColumnsNumber();
        float[][] result = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (((Matrix)getSecondMathObject()).getValue()[i][j]*(float)getFirstMathObject().getValue());
            }
        }
        return new Matrix(result);
    }

    public static Matrix multiplyMatrix() {
        if (((Matrix)getFirstMathObject()).getColumnsNumber() != ((Matrix)getSecondMathObject()).getRowsNumber()) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to rows of second matrix, cannot multiply");
        } else {
            float[][] result = new float[((Matrix)getFirstMathObject()).getRowsNumber()][((Matrix)getSecondMathObject()).getColumnsNumber()];
            float sum = 0;
            for (int i = 0; i < ((Matrix)getFirstMathObject()).getRowsNumber(); i++) {
                for (int j = 0; j < ((Matrix)getSecondMathObject()).getColumnsNumber(); j++) {
                    for (int k = 0; k < ((Matrix)getSecondMathObject()).getRowsNumber(); k++) {
                        sum = sum + ((Matrix)getFirstMathObject()).getValue()[i][k] * ((Matrix)getSecondMathObject()).getValue()[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new Matrix(result);
        }
    }

    public static Matrix addMatrix() {
        if ((((Matrix)getFirstMathObject()).getColumnsNumber() != ((Matrix)getSecondMathObject()).getColumnsNumber()) || (((Matrix)getFirstMathObject()).getRowsNumber() != ((Matrix)getSecondMathObject()).getRowsNumber())) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to columns of second matrix, or number of rows of this matrix is not equal to rows of second matrix");
        } else {
            int rows = ((Matrix)getFirstMathObject()).getRowsNumber();
            int columns = ((Matrix)getFirstMathObject()).getColumnsNumber();
            float[][] result = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = ((Matrix)getFirstMathObject()).getValue()[i][j] + ((Matrix)getSecondMathObject()).getValue()[i][j];
                }
            }
           return new Matrix(result);
        }
    }

    public static Matrix subtractMatrix() {
        if ((((Matrix)getFirstMathObject()).getColumnsNumber() != ((Matrix)getSecondMathObject()).getColumnsNumber()) || (((Matrix)getFirstMathObject()).getRowsNumber() != ((Matrix)getSecondMathObject()).getRowsNumber())) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to columns of second matrix, or number of rows of this matrix is not equal to rows of second matrix");
        } else {
            int rows = ((Matrix)getFirstMathObject()).getRowsNumber();
            int columns = ((Matrix)getFirstMathObject()).getColumnsNumber();
            float[][] result = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = ((Matrix)getFirstMathObject()).getValue()[i][j] - ((Matrix)getSecondMathObject()).getValue()[i][j];
                }
            }
            return new Matrix(result);
        }
    }
}
