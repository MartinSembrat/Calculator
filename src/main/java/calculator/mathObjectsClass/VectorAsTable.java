package calculator.mathObjectsClass;

import javax.swing.*;
import java.util.Arrays;

public class VectorAsTable {
    private int rows;
    private int columns = 1;
    public float[][] content;

    public VectorAsTable(float[][] content) {
        this.content = content;
        this.rows = content.length;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //    public void readVector() {
//        Scanner s = new Scanner(System.in);
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                content[i][j] = s.nextInt();
//            }
//        }
//    }
    public void printVector() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(content[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder arrayContent = new StringBuilder();
        for(float[] row:content){
            if (row!=null){arrayContent.append(Arrays.toString(row)+" ");}
        }
        return "VectorAsTable{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", content=" + arrayContent;
    }
}
