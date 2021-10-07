package calculator.mathObjectsClass;

import java.util.Arrays;

public class Matrix {
    private int rowsNumber;
    private int columnsNumber;
    public float[][] content;

    public Matrix(float[][] content) {
        this.content = content;
        this.rowsNumber = content.length;
        this.columnsNumber = content[0].length;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    //    public void readMatrix() {
//        Scanner s = new Scanner(System.in);
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                content[i][j] = s.nextInt();
//            }
//        }
//    }
    public void printMatrix() {
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                System.out.print(content[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder arrayContent = new StringBuilder();
        for(float[] row:content){
            if (row!=null){arrayContent.append(Arrays.toString(row)+"\n");}
        }
        return "Matrix{" + arrayContent +
                '}';
    }
}

