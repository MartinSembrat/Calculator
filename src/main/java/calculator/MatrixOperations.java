package calculator;

import calculator.mathObjectsClass.Matrix;

public class MatrixOperations {

    public static Matrix matrixMultiplierByNumber(Matrix matrix1, float multiplier) {
        int rows = matrix1.getRowsNumber();
        int columns = matrix1.getColumnsNumber();
        float[][] result = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (matrix1.content[i][j]*multiplier);
            }
        }
        return new Matrix(result);
    }
    public static Matrix matrixMultiplierByNumber(float multiplier, Matrix matrix1) {
        int rows = matrix1.getRowsNumber();
        int columns = matrix1.getColumnsNumber();
        float[][] result = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (matrix1.content[i][j]*multiplier);
            }
        }
        return new Matrix(result);
    }

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsNumber() != matrix2.getRowsNumber()) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to rows of second matrix, cannot multiply");
        } else {
            float[][] result = new float[matrix1.getRowsNumber()][matrix2.getColumnsNumber()];
            float sum = 0;
            for (int i = 0; i < matrix1.getRowsNumber(); i++) {
                for (int j = 0; j < matrix2.getColumnsNumber(); j++) {
                    for (int k = 0; k < matrix2.getRowsNumber(); k++) {
                        sum = sum + matrix1.content[i][k] * matrix2.content[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new Matrix(result);
        }
    }

    public static Matrix addMatrix(Matrix matrix1, Matrix matrix2) {
        if ((matrix1.getColumnsNumber() != matrix2.getColumnsNumber()) || (matrix1.getRowsNumber() != matrix2.getRowsNumber())) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to columns of second matrix, or number of rows of this matrix is not equal to rows of second matrix");
        } else {
            int rows = matrix1.getRowsNumber();
            int columns = matrix1.getColumnsNumber();
            float[][] result = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = matrix1.content[i][j] + matrix2.content[i][j];
                }
            }
           return new Matrix(result);
        }
    }

    public static Matrix subtractMatrix(Matrix matrix1, Matrix matrix2) {
        if ((matrix1.getColumnsNumber() != matrix2.getColumnsNumber()) || (matrix1.getRowsNumber() != matrix2.getRowsNumber())) {
            throw new IllegalArgumentException("number of columns of this matrix is not equal to columns of second matrix, or number of rows of this matrix is not equal to rows of second matrix");
        } else {
            int rows = matrix1.getRowsNumber();
            int columns = matrix1.getColumnsNumber();
            float[][] result = new float[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = matrix1.content[i][j] - matrix2.content[i][j];
                }
            }
            return new Matrix(result);
        }
    }
}
