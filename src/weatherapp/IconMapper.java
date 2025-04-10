package weatherapp;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
//This is a class to select an appropriate icon based on the weather as well as mapping icons to their respective weather events via weather icon code
public class IconMapper {
    private static final Map<String, String> iconMap = new HashMap<>();//Using a hash map KVP for the relationship between 

    static {
        iconMap.put("01d", "sun.png"); 
        iconMap.put("01n", "moon.png"); 
        iconMap.put("02d", "few_clouds.png"); 
        iconMap.put("02n", "few_clouds_night.png"); 
        iconMap.put("03d", "clouds.png");
        iconMap.put("03n", "clouds.png");
        iconMap.put("04d", "broken_clouds.png");
        iconMap.put("04n", "broken_clouds.png");
        iconMap.put("09d", "shower_rain.png");
        iconMap.put("09n", "shower_rain.png");
        iconMap.put("10d", "rain.png");
        iconMap.put("10n", "rain_night.png");
        iconMap.put("11d", "thunderstorm.png");
        iconMap.put("11n", "thunderstorm.png");
        iconMap.put("13d", "snow.png");
        iconMap.put("13n", "snow.png");
        iconMap.put("50d", "mist.png");
        iconMap.put("50n", "mist.png");
    }

    public static String getIconPath(String iconCode) {
        // fallback icon logic and file path
        String iconPath = "resources/icons/" + iconMap.getOrDefault(iconCode, "unknown.png");

        // Get resource URL
        URL iconUrl = IconMapper.class.getClassLoader().getResource(iconPath);
        //exception handling logic
        if (iconUrl == null) {
            System.out.println("ERROR: Could not load icon at " + iconPath);
            return null;
        } else {
            System.out.println("SUCCESS: Loaded " + iconPath);
            return iconUrl.toExternalForm();
        }
    }
}
