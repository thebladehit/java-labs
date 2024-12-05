public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();

        translator.addWord("apple", "яблуко");
        translator.addWord("is", "є");
        translator.addWord("fruit", "фрукт");
        translator.addWord("a", "");

        System.out.println(translator.translate("Apple is a fruit"));
    }
}