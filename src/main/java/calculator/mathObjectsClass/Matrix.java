package calculator.mathObjectsClass;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements MathObject {
    private int rowsNumber;
    private int columnsNumber;
    private float[][] content;

    public Matrix(float[][] content) {
        this.content = content;
        this.rowsNumber = content.length;
        this.columnsNumber = content[0].length;
    }

    @Override
    public float[][] getValue() {
        return content;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    @Override
    public String toString() {
        StringBuilder arrayContent = new StringBuilder();
        for (float[] row : content) {
            if (row != null) {
                arrayContent.append(Arrays.toString(row));
            }
        }
        return "Matrix\n" + arrayContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return rowsNumber == matrix.rowsNumber &&
                columnsNumber == matrix.columnsNumber &&
                Arrays.deepEquals(content, matrix.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rowsNumber, columnsNumber);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}

