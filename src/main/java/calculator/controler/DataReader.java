package calculator.controler;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class DataReader {
    static String name;

    public static String readDataFromConsole() {
        BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in));
        try  {
            name = stringReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
