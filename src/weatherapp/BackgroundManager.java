package weatherapp;

import javafx.scene.layout.*;
import javafx.scene.image.Image;
//This class dynamically updates the background of the application depending on what time of day it is
public class BackgroundManager {

    public static Background getBackground(String localTime) {
        int hour = Integer.parseInt(localTime.split(":")[0]); //gets the local time
//gets background based on time
        String imagePath;
        if (hour >= 5 && hour < 12) {
            imagePath = "/resources/backgrounds/morning.jpg";
        } else if (hour >= 12 && hour < 17) {
            imagePath = "/resources/backgrounds/day.jpg";
        } else if (hour >= 17 && hour < 20) {
            imagePath = "/resources/backgrounds/evening.jpg";
        } else {
            imagePath = "/resources/backgrounds/night.jpg";
        }

     // Debugging information
        System.out.println("Background Path Debug: " + BackgroundManager.class.getResource(imagePath));
//converting an image path into a URL format compatible with JavaFX
        String bgUrl = BackgroundManager.class.getResource(imagePath).toExternalForm();
        System.out.println("DEBUG: Background Image URL -> " + bgUrl);
//load image and create background object
        Image image = new Image(bgUrl);
        BackgroundImage bgImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        return new Background(bgImage);

    }
}
