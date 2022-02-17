package calculator.controler;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static calculator.currentState.CurrentOperation.*;

//TODO use singleton to enable serialization of an instance with a configuration
public class SaveToFile {
    protected static int counter = 1;
    static private int maxOperationNumberPerFile = 2;
    static private int currentOperationNumberInFile = 1;
    static private java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
    static private DateFormat df = new SimpleDateFormat("dd_MM_yyyy_");
    protected static String formattedDate = df.format(date);
    protected static String path = ".\\src\\main\\java\\calculator\\history\\";

    public static boolean saveToFile() {
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
}