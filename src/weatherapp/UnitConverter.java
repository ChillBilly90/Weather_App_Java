package weatherapp;

//This file is pretty obvious, we're converting metric to standard and standard to metric with regard to distance and temperature
//Having this conversion to metric is important if you want your app to be used in more than three or four countries
public class UnitConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double kmhToMph(double kmh) {
        return kmh * 0.621371;
    }

    public static double mphToKmh(double mph) {
        return mph / 0.621371;
    }
}
