package calculator.controler;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static calculator.model.CurrentOperation.*;

//TODO use singleton to enable serialization of an instance with a configuration
public class SaveToFile {
    static int counter = 1;
    static int maxOperationNumberPerFile = 2;
    static int currentOperationNumberInFile = 1;
    static java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
    static DateFormat df = new SimpleDateFormat("dd_MM_yyyy_");
    static String formattedDate = df.format(date);
    static String path = ".\\src\\main\\java\\calculator\\history\\";

    static boolean saveToFile() {
        File file;
        file = new File(path + "CalculationHistory" + formattedDate + counter + ".txt");
        if (file.exists() && currentOperationNumberInFile > maxOperationNumberPerFile) {
            currentOperationNumberInFile = 1;
            ++counter;
            file = new File(path + "CalculationHistory" + formattedDate + counter + ".txt");
            System.out.println(file.getAbsolutePath());
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            System.out.println("Operation " + currentOperationNumberInFile+":");
            pw.println("Operation " + currentOperationNumberInFile);
            pw.println(getFirstMathObject());
            pw.println(getMathOperation());
            pw.println(getSecondMathObject());
            pw.println(getResult() + "\n");
            pw.close();
            currentOperationNumberInFile++;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<=5;i++)
        saveToFile();
    }
}