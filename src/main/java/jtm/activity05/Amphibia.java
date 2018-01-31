package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
	private Ship ship;
	private Vehicle vehicle;
	
	public Amphibia(String id, float consumption, int tankSize,
			byte sails, int wheels) {
		super(id, consumption, tankSize);
		ship = new Ship(id, sails);
		vehicle = new Vehicle(id, consumption, tankSize, wheels);
	}
	
	
	public String move(Road road) {
		if(road instanceof WaterRoad){
			return String.format("%s is sailing on %s with %d sails",
					this.getType(), road.toString(), ship.numberOfSails);
		} else {
			if(getNececeryFuel(road) <= this.getFuelInTank()){
				this.setFuelInTank(this.getFuelInTank() - this.getNececeryFuel(road));
				return String.format("%s is driving on %s with %d wheels",
				this.getType(), road.toString(), vehicle.numberOfWheels);
			} else return String.format("Cannot move on %s. Necessary fuel:%.2fl, fuel in tank:%.2fl",
					road.toString(), this.getNececeryFuel(road), this.getFuelInTank());
		}
	}
	
	
	
}
