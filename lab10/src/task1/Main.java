package task1;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String literal = "some string";

        System.out.println("String from input: ");
        String fromKeyboard = scanner.nextLine();

        System.out.println("Literal before: " + literal);
        System.out.println("From keyboard before: " + fromKeyboard);

        Class<?> stringClass = String.class;
        Field valueField = stringClass.getDeclaredField("value");
        valueField.setAccessible(true);
        byte[] literalChars = (byte[]) valueField.get(literal);
        byte[] fromKeyboardChars = (byte[]) valueField.get(fromKeyboard);

        byte[] newCharArray = "some new text".getBytes();
        System.arraycopy(newCharArray, 0, literalChars, 0, Math.min(literalChars.length, newCharArray.length));
        System.arraycopy(newCharArray, 0, fromKeyboardChars, 0, Math.min(fromKeyboardChars.length, newCharArray.length));

        System.out.println("Literal after: " + literal);
        System.out.println("From keyboard after: " + fromKeyboard);
    }
}
