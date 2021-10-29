package calculator.mathObjectsClass;

import java.util.Arrays;
import java.util.Objects;

public class VectorAsTable implements MathObject {
    private int rows;
    private int columns = 1;
    private float[][] content;

    public VectorAsTable(float[][] content) {
        this.content = content;
        this.rows = content.length;
    }

    @Override
    public float[][] getValue() {
        return content;
    }

    public int getRowsNumber() {
        return rows;
    }

    public int getColumnsNumber() {
        return columns;
    }

    @Override
    public String toString() {
        String arrayContent = Arrays.deepToString(content);
        return "Vector " +rows+" "+ arrayContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorAsTable that = (VectorAsTable) o;
        return rows == that.rows &&
                columns == that.columns &&
                Arrays.deepEquals(content, that.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
