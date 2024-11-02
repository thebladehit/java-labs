package firstTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private final String filePath;

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public String getLongestString() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int wordsCount = 0;
            String savedString = "";
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (words.length > wordsCount) {
                    wordsCount = words.length;
                    savedString = line;
                }
            }
            return savedString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
