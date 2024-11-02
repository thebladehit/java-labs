package firstTask;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader(System.getProperty("user.dir") + "/src/firstTask/text.txt");
        String longestString = reader.getLongestString();
        System.out.println(longestString);
    }
}
