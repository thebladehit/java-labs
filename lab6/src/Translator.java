import java.util.HashMap;
import java.util.Locale;

public class Translator {
    private HashMap<String, String> dictionary = new HashMap<>();

    public void addWord(String firstWord, String secondWord) {
        dictionary.put(firstWord.toLowerCase(Locale.ROOT), secondWord.toLowerCase(Locale.ROOT));
    }

    public String translate(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder translation = new StringBuilder();
        for (String word : words) {
            String translatedWord = dictionary.getOrDefault(word.toLowerCase(Locale.ROOT), word.toLowerCase(Locale.ROOT));
            translation.append(translatedWord).append(" ");
        }
        return translation.toString();
    }
}
