package fourthTask;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public HashMap<String, Integer> parse(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String html = response.body();

            Pattern tagPattern = Pattern.compile("</([^<>\\s]+)>");
            Matcher matcher = tagPattern.matcher(html);

            HashMap<String, Integer> tagCounterMap = new HashMap<>();
            while (matcher.find()) {
                String tag = matcher.group(1);
                tagCounterMap.put(tag, tagCounterMap.getOrDefault(tag, 0) + 1);
            }
            return tagCounterMap;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
