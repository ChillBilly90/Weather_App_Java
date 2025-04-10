package weatherapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class SearchHistoryManager {
    private final List<String> history = new LinkedList<>(); //using final to point to same space in memory, we use LinkedList for the ease of list manipulation
    private final int MAX_ENTRIES = 10; // limit history size
//adds search keywords to list of search history as well as details of when the search happened
    public void addSearch(String cityName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String entry = timestamp + " - " + cityName;

        if (history.size() >= MAX_ENTRIES) {
            history.remove(0); // remove oldest if list starts to not respect the MAX_ENTRIES variable limit
        }
        history.add(entry);
    }

    public List<String> getHistory() {
        return history;
    }
}
