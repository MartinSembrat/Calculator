package calculator.controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReader {

    static BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in));
    //TODO prevent creating multiple instances of String
    public static String readDataFromConsole() {
        String name = null;
        try {
            name = stringReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
