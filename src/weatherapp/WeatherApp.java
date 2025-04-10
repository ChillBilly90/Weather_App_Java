package weatherapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.InputStream;

public class WeatherApp extends Application {

    private Label resultLabel;
    private ImageView weatherIcon;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Information App");

        // Input Field
        TextField cityInput = new TextField();
        cityInput.setPromptText("City, CountryCode (e.g., 'Paris, FR')");
        cityInput.setTooltip(new Tooltip("Enter city & country code (e.g., 'London, GB' or 'Tokyo, JP')"));

        // Search Button instantiation
        Button searchButton = new Button("Get Weather");

        // Output Label
        resultLabel = new Label("Weather info will appear here.");
        weatherIcon = new ImageView(); 
        weatherIcon.setFitWidth(50);
        weatherIcon.setFitHeight(50);

        // Unit conversion toggle
        CheckBox unitToggle = new CheckBox("Use Imperial Units (°F / mph)");

        // Search Button Event Handler
        searchButton.setOnAction(e -> {
            String city = cityInput.getText().trim();

            if (city.isEmpty()) {
                resultLabel.setText("Please enter a city.");
                return;
            }

            try {
                // Firing off fetch request defined in WeatherService.java
                WeatherData data = WeatherService.getCurrentWeather(city);

                boolean useImperial = unitToggle.isSelected();
                double temp = data.getTemperature();
                double wind = data.getWindSpeed();

                String tempText = useImperial
                    ? String.format("%.1f°F", UnitConverter.celsiusToFahrenheit(temp))
                    : String.format("%.1f°C", temp);

                String windText = useImperial
                    ? String.format("%.1f mph", UnitConverter.kmhToMph(wind))
                    : String.format("%.1f km/h", wind);

                //Loading the icon chosen by IconMapper with fallback icon logic
                String iconPath = IconMapper.getIconPath(data.getIconCode());
                if (iconPath != null) {
                    Image iconImage = new Image(iconPath);
                    weatherIcon.setImage(iconImage);
                    System.out.println("SUCCESS: Loaded icon from " + iconPath);//debugging text
                } else {
                    System.out.println("ERROR: Using fallback icon.");//debugging text
                    weatherIcon.setImage(new Image(getClass().getResourceAsStream("/icons/unknown.png")));
                }


                //concatenating the variable values, representing weather aspects with their respective labels for fall back
                resultLabel.setText(
                    "Location: " + data.getCityName() + "\n" +
                    "Temp: " + tempText + "\n" +
                    "Wind: " + windText + "\n" +
                    "Conditions: " + data.getDescription()
                );

            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
                weatherIcon.setImage(new Image(getClass().getResourceAsStream("/icons/unknown.png")));
            }
        });

        // JavaFX layout, a new hbox is made for the weather icon and information display
        HBox iconAndResult = new HBox(10, weatherIcon, resultLabel);
        VBox layout = new VBox(10, cityInput, unitToggle, searchButton, iconAndResult);
        layout.setPadding(new Insets(20));

        // Apply Background Image Dynamically
        Background bg = BackgroundManager.getBackground("12:00");
        layout.setBackground(bg);
//scene creation and render code
        Scene scene = new Scene(layout, 350, 280);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
