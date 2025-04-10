package weatherapp;

import java.io.InputStream;
// JSON imported as it's the most used format for API information
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private static final String API_KEY = "0e9fdd070c7acd8a5460521f0879c02f"; // API key grabbed from weather site
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather"; // site to use API key with

    // Turns API request from String type to a URL object.
    public static WeatherData getCurrentWeather(String city) throws Exception {
        String urlString = BASE_URL + "?q=" + city.replace(" ", "%20") + "&appid=" + API_KEY + "&units=metric";

        // Debugging line to check if the URL is correct before making the request
        System.out.println("Requesting URL: " + urlString);

        URL url = new URL(urlString);

        // The request is converted to pass using HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Listening for a response from the weather API.
        int status = conn.getResponseCode();
        System.out.println("DEBUG: API Response Code -> " + status); // 🔥 Print API status

        if (status == 400) {
            throw new Exception("Invalid location format! Try 'City, CountryCode' (e.g., 'Paris, FR').");
        } else if (status == 404) {
            throw new Exception("Location not found! Double-check spelling and try again.");
        } else if (status != 200) {
            throw new Exception("Unexpected API error (Status: " + status + "). Try again later.");
        }

        // Get InputStream from API
        InputStream apiStream = conn.getInputStream();
        if (apiStream == null) {
            throw new Exception("ERROR: API InputStream is NULL! API request failed.");
        }

        // Wrap it in BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(apiStream));

        StringBuilder responseBuilder = new StringBuilder();
        String line;

        // Read the API response
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }

        // Closing resources
        reader.close();
        conn.disconnect();

        // DEBUG: Print out the API response
        System.out.println("DEBUG: API Response -> " + responseBuilder.toString());

        // Create JSON object from response
        JSONObject json = new JSONObject(responseBuilder.toString());

        // Extract data
        String cityName = json.getString("name");
        JSONObject main = json.getJSONObject("main");
        JSONArray weatherArray = json.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);
        JSONObject wind = json.getJSONObject("wind");

        double temp = main.getDouble("temp");
        double humidity = main.getDouble("humidity");
        double windSpeed = wind.getDouble("speed");
        String description = weather.getString("description");
        String iconCode = weather.getString("icon");

        // Get local time via timezone offset i.e. GMT
        long timestamp = json.getLong("dt");
        int offset = json.getInt("timezone");
        String localTime = java.time.ZonedDateTime.ofInstant(
                java.time.Instant.ofEpochSecond(timestamp + offset),
                java.time.ZoneOffset.UTC
        ).toLocalTime().toString();

        // Return a new WeatherData object with parsed values
        return new WeatherData(cityName, description, temp, humidity, windSpeed, iconCode, localTime);
    }
}
