package weatherapp;


public class WeatherData {
    // Store weather data fields from API response
    private String cityName;
    private String description;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String iconCode;
    private String localTime;

 //constructor using the API parsed data
    public WeatherData(String cityName, String description, double temperature, double humidity, double windSpeed, String iconCode, String localTime) {
        this.cityName = cityName;
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.iconCode = iconCode;
        this.localTime = localTime;
    }

    // Getters for encapsulated fields so other classes (like the UI) can access them
    public String getCityName() { return cityName; }
    public String getDescription() { return description; }
    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public double getWindSpeed() { return windSpeed; }
    public String getIconCode() { return iconCode; }
    public String getLocalTime() { return localTime; }
}
