package calculator.mathObjectsClass;

import java.util.Arrays;

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
}
