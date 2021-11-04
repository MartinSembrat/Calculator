package calculator.controler;

import org.junit.jupiter.api.Test;

import static calculator.controler.SaveToFile.saveToFile;
import static org.junit.jupiter.api.Assertions.*;

class SaveToFileTest {

    @Test
    void saveToFileTest() {
        assertTrue(saveToFile());
    }
}