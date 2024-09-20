package task2;

import java.util.Scanner;

public class CommandLineSpeaker {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Journal journal = new Journal();

        while (true) {
            System.out.print("\n1-exit\n2-show journal\n3-add to journal\n");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                System.out.print("Bye");
                return;
            } else if (command.equals("2")) {
                System.out.print(journal.getRecords());
            } else if (command.equals("3")) {
                String[] userInput;
                while (true) {
                    userInput = getArguments(scanner);
                    if (!Journal.validateData(userInput)) {
                        System.out.println("Invalid data");
                    } else break;
                }
                journal.addRecord(new Record());
                System.out.print("Record was added to journal");
            }
        }
    }

    private static String[] getArguments(Scanner scanner) {
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter birthday data: ");
        String birth = scanner.nextLine();

        System.out.print("Enter phone(only digits): ");
        String age = scanner.nextLine();

        return new String[]{surname, name, birth, age};
    }
}
