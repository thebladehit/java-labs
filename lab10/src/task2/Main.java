package task2;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class Main {
    private static ResourceBundle messages;
    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {
        setupLogger();
        logger.info("Application started");

        Locale locale = new Locale("en");
        messages = ResourceBundle.getBundle("resources.location.messages", locale);

        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - " + messages.getString("menu.option1"));
            System.out.println("2 - " +messages.getString("menu.option2"));
            System.out.println("q - " + messages.getString("menu.exit"));
            System.out.print("> ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print(messages.getString("prompt.enter_url"));
                String url = scanner.nextLine();
                logger.config("User provided URL: " + url);
                HashMap<String, Integer> tags = parser.parse(url);
                if (tags == null) {
                    logger.warning("Parsing returned null, exiting.");
                } else {
                    TreeMap<String, Integer> treeMap = new TreeMap<>(tags);
                    System.out.println(treeMap);

                    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(tags.entrySet());
                    sortedList.sort(Map.Entry.comparingByValue());
                    System.out.println(sortedList);
                }
            } else if (choice.equals("2")) {
                System.out.println("1 - English, 2 - Українська");
                System.out.print("> ");
                String langChoice = scanner.nextLine();
                switch (langChoice) {
                    case "1":
                        locale = new Locale("en");
                        break;
                    case "2":
                        locale = new Locale("uk");
                        break;
                    default:
                        System.out.println("Invalid choice, defaulting to English.");
                }
                messages = ResourceBundle.getBundle("resources.location.messages", locale);
                logger.info("Language switched to: " + locale.getLanguage());
            } else if (choice.equals("q")) {
                System.out.println("Goodbye!");
                logger.info("Application finished successfully");
                logger.warning("WARN");
                return;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }

    private static void setupLogger() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        rootLogger.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setLevel(Level.WARNING);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}