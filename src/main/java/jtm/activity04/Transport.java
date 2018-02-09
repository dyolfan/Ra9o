package jtm.activity04;

public class Transport {
	private float consumption; // fuel consumption in litres per 100km
	private float fuelInTank; // fuel in tank
	// Do not change access modifiers to encapsulate internal properties!
	private String id; // Transport registration number
	private int tankSize; // tank size in litres

	/*- #1
	 * Select menu Source — Generate Constructor using Fields...
	 * and create constructor which sets id, consumption, tankSize
	 * values of the newly created object
	 * And make fuel tank full.
	 */

	public Transport(String id) {
		this.id = id;
	}

	public Transport(String id, float consumption, int tankSize) {
		this.id = id;
		this.consumption = consumption;
		this.tankSize = tankSize;
		this.fuelInTank = tankSize;
	}

	/*- #2
	 * Select menu: Source — Generate getters and Setters...
	 * and generate public getters for consumption, tankSize, id, and
	 * fuelInTank fields
	 */

	public float getConsumption() {
		return consumption;
	}

	public float getFuelInTank() {
		return fuelInTank;
	}

	public String getId() {
		return id;
	}

	public float getNececeryFuel(Road road) {
		float consumptionPerKm = this.getConsumption() / 100;
		float necFuel = 0;
		necFuel = road.getDistance() * consumptionPerKm;
		return necFuel;
	}

	public int getTankSize() {
		return tankSize;
	}

	// Return transport id and type as string e.g. "AAA Transport"
	// HINT: use this.getClass().getSimpleName(); to get type of transport
	protected final String getType() {
		// return required value
		return String.format("%s %s", this.getId(), this.getClass().getSimpleName());
	}

	public String move(Road road) {
		// If transport has enough fuel, decrease actual amount of fuel by
		// necessary amount and return String in form:
		// "AAA Type is moving on From–To, 180km"

		if (getNececeryFuel(road) <= this.getFuelInTank()) {
			fuelInTank -= this.getNececeryFuel(road);
			return String.format("%s is moving on %s", this.getType(), road.toString());
		}

		// If there is no enough fuel in tank, return string in form:
		// "Cannot move on From–To, 180km. Necessary
		// fuel:0.00l, fuel in tank:0.00l"

		else
			return String.format("Cannot move on %s. Necessary fuel:%.2fl, fuel in tank:%.2fl", road.toString(),
					this.getNececeryFuel(road), this.getFuelInTank());
	}

	public void setConsumption(float consumption) {
		this.consumption = consumption;
	}

	/*- #3
	 * Select menu: Source — Generate toString()...
	 * and implement this method, that t returns String in form:
	 * "Id:ID cons:0.0l/100km, tank:00l, fuel:00.00l"
	 * 	HINT: use String.format(Locale.US, "%.2f", float) to limit shown numbers
	 *  to 2 decimal for fractions, and dot as a decimal delimiter.
	 */

	public void setFuelInTank(float fuelInTank) {
		this.fuelInTank = fuelInTank;
	}

	public void setId(String id) {
		this.id = id;
	}

	// HINT: use getType() to describe transport and road.toString() to describe
	// road
	// HINT: String.format(Locale.US, "%.2f", float) to format float number with
	// fixed mask

	public void setTankSize(int tankSize) {
		this.tankSize = tankSize;
	}

	@Override
	public String toString() {
		return String.format("Id:%s cons:%.1fl/100km, tank:%dl, fuel:%.2fl", this.id, this.consumption, this.tankSize,
				this.fuelInTank);
	}

}
