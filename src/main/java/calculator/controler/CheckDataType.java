package calculator.controler;

import calculator.exceptions.NotEqualsRowsInMatrix;
import calculator.mathObjectsClass.Matrix;
import calculator.mathObjectsClass.RealNumber;
import calculator.mathObjectsClass.VectorAsTable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

//has one static method to convert string to mathematical object
public class CheckDataType {

    public static final String COMMA = ",";
    public static final String BRACKETS = "[\\[\\]]";
    public static final String DUBBLEBRACKETS = "]\\s?,\\s?\\[";
    public static final String REAL_NUMBER_PATTERN_STRING = "[+-]?[0-9]+[.]?[0-9]*";
    public static final String VECTOR_PATTERN_STRING = "\\[(?:("+REAL_NUMBER_PATTERN_STRING+")[,]?){1,4}]";
//  public static final String VECTOR_PATTERN_STRING = "\\[("+REAL_NUMBER_PATTERN_STRING+")[,]?("+REAL_NUMBER_PATTERN_STRING+")?[,]?("+REAL_NUMBER_PATTERN_STRING+")?[,]?("+REAL_NUMBER_PATTERN_STRING+")?]";
    public static final String MATRIX_PATTERN_STRING = "(?:("+VECTOR_PATTERN_STRING+")[,]?){1,4}";
//  public static final String MATRIX_PATTERN_STRING = "("+VECTOR_PATTERN_STRING+")[,]?("+VECTOR_PATTERN_STRING+")?[,]?("+VECTOR_PATTERN_STRING+")?[,]?("+VECTOR_PATTERN_STRING+")?";
    public static final Pattern REAL_NUMBER_PATTERN = compile(REAL_NUMBER_PATTERN_STRING);
    public static final Pattern VECTOR_PATTERN = compile(VECTOR_PATTERN_STRING);
    public static final Pattern MATRIX_PATTERN = compile(MATRIX_PATTERN_STRING);


    public static <T> T convertStringToMathematicalObject(String inputString){
        Matcher realNumberData = REAL_NUMBER_PATTERN.matcher(inputString);
        Matcher vectorData = VECTOR_PATTERN.matcher(inputString);
        Matcher matrixData = MATRIX_PATTERN.matcher(inputString);
        boolean itsRealNumber = realNumberData.matches();
        boolean itsVector = vectorData.matches();
        boolean itsMatrix = matrixData.matches();
        T convertedMathObject = null;

        if (itsRealNumber) {
            convertedMathObject = (T) new RealNumber(Float.parseFloat(realNumberData.group(0)));
        } else if (itsVector) {
            String[] tabOfFloatString = vectorData.group(0).replaceAll(BRACKETS, "").split(COMMA);
            float[][] vectorTable = new float[tabOfFloatString.length][1];
            for (int i = 0; i < vectorTable.length; i++) {
                vectorTable[i][0] = Float.parseFloat(tabOfFloatString[i]);
            }
            convertedMathObject = (T) new VectorAsTable(vectorTable);
        }else if (itsMatrix){
            String[] tabOfStringsForMatrix = matrixData.group(0).replace("("+BRACKETS+")$", "").replace("^("+BRACKETS+")","").split(DUBBLEBRACKETS);
            System.out.println("table size: "+tabOfStringsForMatrix.length+" x "+tabOfStringsForMatrix[0].length());
            float[][] matrixTable = new float[matrixData.groupCount()][];
            //for check if all rows in matrix are equals
            int[] rowsLenght = new int[matrixTable.length];
            for (int i = 0; i < tabOfStringsForMatrix.length; i++) {
                String[] iElementFromTabOfStringsForMatrix = tabOfStringsForMatrix[i].split(COMMA);
                //for check if all rows in matrix are equals
                rowsLenght[i] = iElementFromTabOfStringsForMatrix.length;
                for (int j = 0; j < tabOfStringsForMatrix[i].length(); j++) {
                    matrixTable[i][j] =  Float.parseFloat(iElementFromTabOfStringsForMatrix[j]);
                }
            }
            //check if all rows in matrix are equals
            for (int row=1; row<rowsLenght.length ;row++){
                if (rowsLenght[0]!= rowsLenght[row]) try {
                    throw new NotEqualsRowsInMatrix("Matrix - rows are not equals");
                } catch (NotEqualsRowsInMatrix notEqualsRowsInMatrix) {
                    notEqualsRowsInMatrix.printStackTrace();
                }
            }
            convertedMathObject = (T) new Matrix(matrixTable);
        }
        return convertedMathObject;
    }
}
