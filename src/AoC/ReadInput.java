package AoC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadInput {
    BufferedReader reader;

    public ReadInput(String filePath) {
        try {
            reader = new BufferedReader(new FileReader("resources/AoC2023/" + filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException ignored) {
        }
    }

}
