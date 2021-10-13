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

//    public void printVector() {
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(content[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    @Override
    public String toString() {
        StringBuilder arrayContent = new StringBuilder();
        for (float[] row : content) {
            if (row != null) {
                arrayContent.append(Arrays.toString(row)).append(" ");
            }
        }
        return "Vector{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", content=" + arrayContent;
    }
}
