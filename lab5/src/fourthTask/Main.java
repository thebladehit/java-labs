package fourthTask;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        String url = scanner.nextLine();
        HashMap<String, Integer> tags = parser.parse(url);

        TreeMap<String, Integer> treeMap = new TreeMap<>(tags);
        System.out.println(treeMap);

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(tags.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());
        System.out.println(sortedList);
    }
}
