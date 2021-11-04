package calculator.controler;

        import calculator.mathObjectsClass.Matrix;
        import calculator.mathObjectsClass.RealNumber;
        import calculator.mathObjectsClass.VectorAsTable;
        import org.junit.jupiter.api.Test;
        import static calculator.controler.CheckDataType.convertStringToMathematicalObject;
        import static org.junit.jupiter.api.Assertions.*;

class CheckDataTypeTest {

    @Test
    void convertStringToMathematicalObjectTest() {
        assertTrue(convertStringToMathematicalObject("9") instanceof RealNumber);
        assertTrue(convertStringToMathematicalObject("-9.99") instanceof RealNumber);
        assertTrue(convertStringToMathematicalObject("[12.3,99.9,-5,0.21]") instanceof VectorAsTable);
        assertTrue(convertStringToMathematicalObject("[1,2,3,4],[0,0,0,0],[12.3,99.9,-5,0.21]") instanceof Matrix);
    }
}