  _____    _   _  U _____ u                 U _____ u    _       _____    _   _  U _____ u   ____            _       ____     ____    
 |_ " _|  |'| |'| \| ___"|/     __        __\| ___"|/U  /"\  u  |_ " _|  |'| |'| \| ___"|/U |  _"\ u     U  /"\  u U|  _"\ uU|  _"\ u 
   | |   /| |_| |\ |  _|"       \"\      /"/ |  _|"   \/ _ \/     | |   /| |_| |\ |  _|"   \| |_) |/      \/ _ \/  \| |_) |/\| |_) |/ 
  /| |\  U|  _  |u | |___       /\ \ /\ / /\ | |___   / ___ \    /| |\  U|  _  |u | |___    |  _ <        / ___ \   |  __/   |  __/   
 u |_|U   |_| |_|  |_____|     U  \ V  V /  U|_____| /_/   \_\  u |_|U   |_| |_|  |_____|   |_| \_\      /_/   \_\  |_|      |_|      
 _// \\_  //   \\  <<   >>     .-,_\ /\ /_,-.<<   >>  \\    >>  _// \\_  //   \\  <<   >>   //   \\_      \\    >>  ||>>_    ||>>_    
(__) (__)(_") ("_)(__) (__)     \_)-'  '-(_/(__) (__)(__)  (__)(__) (__)(_") ("_)(__) (__) (__)  (__)    (__)  (__)(__)__)  (__)__)  


This application was developed using Java for most of the programming but also includes JavaFX for the front end
as well as JSON file format for the API data. This app is simple to setup and easy to use provided you follow the directions below.
 
Installation instructions

1. Download the zipfile and extract the project folder

2. Open the app folder in your preferred IDE

3. Ensure required dependancies are setup
	If JavaFX or JSON libraries are missing follow these steps:
		1. Download JavaFX SDK https://openjfx.io/
		2. Add JavaFX lib folder to your IDE build path
		3. Configure VM arguments in Run Configurations using --module-path "path to your java file here" --add-modules javafx.controls,javafx.fxml
		4. If org.json is missing add the required JAR to the build path
		

Running the Application
1. open eclipse or your choice of IDE
2. right click the folder in your IDE folder explorer and select run as Java Application




Using the program

1. Format: Due to the way the API fetches the data or limitations of the source site all locations must follow a certain format
"City, Country". Any other format may not be fetched properly by the API and result in an error.

2. Toggle: There is a toggle on the page that will switch between imperial and metric measurements.

3. Once you have the proper location format as well as your desired measurement system you can click 
"Get Weather" and the app will fetch real-time weather data.

4. View results will generally include the location, temperature, windspeed and weather conditions.

Troubleshooting

Error: "API request failed"
Solution: 1. Ensure your internet connection is stable
		  2. Make sure the API key is valid
		  3. Try using a different format like "City, Country"

Error: "JavaFX runtime components are missing"
Solution: Add JavaFX library to your IDE build path

Error: "Location not found"
Solution: 1. Use "City, Country" format
		  2. OpenWeatherMap defaults to the largest city with that name in the specified country
		  
		  
		  
License
This project is for educational purposes. Modify and use freely

Roadmap
add global geolocation support
improve location auto suggestions