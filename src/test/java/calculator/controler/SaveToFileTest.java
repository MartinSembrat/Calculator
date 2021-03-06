package calculator.controler;

import calculator.history_save_controllers.SaveToFile;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static calculator.history_save_controllers.SaveToFile.formattedDate;
import static calculator.history_save_controllers.SaveToFile.counter;
import static calculator.history_save_controllers.SaveToFile.saveToFile;
import static org.junit.jupiter.api.Assertions.*;

class SaveToFileTest {

    @Test
    void saveToFileTest() throws IOException {
        assertTrue(saveToFile());
        byte b;
        Path path = Paths.get(SaveToFile.path + "CalculationHistory" + formattedDate + counter + ".txt");
        File  file = new File(String.valueOf(path));
        RandomAccessFile f = new RandomAccessFile(file, "rw");
        long length = f.length() - 1;
        for (int i=0; i<=5;i++){
            do {
                length -= 1;
                f.seek(length);
                b = f.readByte();
            } while(b != 10 && length>0);
            f.setLength(length+1);
        }
        if (f.length()<2){
            f.close();
            Files.deleteIfExists(path);
            System.out.println("deleted");}
    }
}