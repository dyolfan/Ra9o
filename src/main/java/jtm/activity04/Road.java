package jtm.activity04;

public class Road {
	private int distance; // distance in km
	private String from; // Start point
	private String to; // End point

	/*- #1
	 * Select menu Source — Generate Constructor using Fields...
	 * and create constructor which sets from, to and distance
	 * values of the newly created object
	 */

	public Road() {
		this.from = "";
		this.to = "";
		this.distance = 0;
	}

	/*-	#2
	 * Create constructor without parameters, which sets empty
	 * values or 0 to all object properties
	 */

	public Road(String from, String to, int distance) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	/*- #3
	 * Select menu: Source — Generate getters and Setters...
	 * and generate public getters/setters for distance, from and to
	 * fields
	 */

	public int getDistance() {
		return distance;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	/*- #4
	 * Select menu: Source — Generate toString()...
	 * and implement this method, that it returns String in form:
	 * "From — To, 00km"
	 * Note that — is not dash ("minus key" in jargon), but m-dash!
	 * See more at: https://en.wikipedia.org/wiki/Dash
	 */

	@Override
	public String toString() {
		return getFrom() + " — " + getTo() + ", " + getDistance() + "km";
	}

}
