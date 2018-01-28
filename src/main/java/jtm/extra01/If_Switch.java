
package jtm.extra01;

/**
 * 
 * @author student IB
 * 
 */
public class If_Switch {

	public static final String SUNNY = "SUNNY";
	public static final String RAINY = "RAINY";
	public static final String SNOWY = "SNOWY";

	public static final String COLD = "COLD";
	public static final String WARM = "WARM";
	public static final String HOT = "HOT";

	public static final int WINTER = 1;
	public static final int SPRING = 2;
	public static final int SUMMER = 3;
	public static final int AUTUMN = 4;
	public static final int UNRECOGNISED = 0;

	/**
	 * Creates an instance of the Season. Season is defined by weather and
	 * temperature parameters. If parameters are invalid, then season is
	 * unrecognized.
	 * 
	 * @param weather
	 *            weather
	 * @param temperature
	 *            temperature
	 * @param season
	 *            season
	 */
	// TODO No. 1: Write instance variables that will handle the String value
	// of weather and temperature
	// and the Integer value of season.

	public If_Switch(String weather, String temperature) {

		// TODO No. 2: Write code that will filter seasons by the rules:
		// Winter - cold and snowy
		// Spring - warm and sunny, maybe snowy
		// Summer - hot and sunny, definitely not snowy
		// Autumn - warm and rainy
		// Assign the season argument to an instance variable respectively
		// If the arguments were not filtered, make a code that will assign
		// instance variable to a UNRECOGNISED value
		// HINT: Use if-else.
	}

	/**
	 * Return a String representation of this season.
	 * 
	 * @return the String representation of this season
	 */
	public String returnSeason() {
		// TODO No. 3: Make a code that will convert the Integer value of season
		// into String.
		// Return the String value of the current season.
		// Make a code that will return the String value of UNRECOGNISED if the
		// default
		// value was chosen
		// HINT: Use switch-case.
		return "";
	}
}
