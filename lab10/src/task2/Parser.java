package task2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Logger logger = Logger.getLogger("");

    public HashMap<String, Integer> parse(String url) {
        logger.info("Starting parsing for URL: " + url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String html = response.body();
            logger.fine("Received HTML content with length: " + html.length());

            Pattern tagPattern = Pattern.compile("</([^<>\\s]+)>");
            Matcher matcher = tagPattern.matcher(html);

            HashMap<String, Integer> tagCounterMap = new HashMap<>();
            while (matcher.find()) {
                String tag = matcher.group(1);
                tagCounterMap.put(tag, tagCounterMap.getOrDefault(tag, 0) + 1);
            }
            logger.info("Tag parsing completed. Total unique tags: " + tagCounterMap.size());
            return tagCounterMap;
        } catch (IOException | InterruptedException e) {
            logger.severe("Error occurred while parsing URL: " + url);
            return null;
        }
    }
}