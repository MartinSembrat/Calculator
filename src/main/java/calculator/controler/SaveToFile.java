package calculator.controler;

import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.VectorAsTable;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static calculator.enums.EMathOperationsConstans.MULTIPLICATION;
import static calculator.model.CurrentOperation.*;

//TODO dodać serializację aby zapisać konfigurację klasy
public class SaveToFile {
    static int counter = 9;
    static java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
    static DateFormat df = new SimpleDateFormat("dd_MM_yyyy_");
    static String formattedDate = df.format(date);
    static String path = ".\\src\\main\\java\\calculator\\history\\";
    static String filename = "CalculationHistory" + formattedDate + counter + ".txt";


    static void saveToFile() {
        File file = new File(path + filename);
        if (file.exists()) {
            System.out.println("Exists");
        } else {
            System.out.println("Does not Exists");
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {

            pw.println(getFirstMathObject());
            pw.println(getMathOperation());
            pw.println(getSecondMathObject());
            pw.println(getResult()+"\n");

            pw.close();
            System.out.println(
                    "File is created successfully with the content.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setFirstMathObject(new VectorAsTable(new float[][]{{1f}, {2f}}));
        setMathOperation(MULTIPLICATION);
        setSecondMathObject(new Matrix(new float[][]{{1, 1, 1, 1}, {2, 2, 2, 2}}));
//        setResult();


        saveToFile();
    }

}