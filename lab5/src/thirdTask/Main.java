package thirdTask;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        String fileWriteTo = inputReader.readLine("Write to: ");
        String fileReadFrom = inputReader.readLine("Read from: ");
        char keyChar = 'r';

        try (EncryptionWriter writer = new EncryptionWriter(new FileWriter(fileWriteTo), keyChar)) {
            String value = inputReader.readLine("Enter value: ");
            writer.write(value, 0, value.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DecryptionReader reader = new DecryptionReader(new FileReader(fileReadFrom), keyChar)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputReader.close();
    }
}
