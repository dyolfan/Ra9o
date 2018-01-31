package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
	protected int numberOfWheels;

	public Vehicle(String id, float consumption, int tankSize, int wheels) {
		super(id, consumption, tankSize);
		this.numberOfWheels = wheels;
	}
	
	
	
	
	@Override
	public String move(Road road) {
		if(road.getClass() == Road.class) {
			this.setFuelInTank(this.getFuelInTank() - this.getNececeryFuel(road));
			return String.format("%s is driving on %s with %d wheels",
								this.getType(), road.toString(), numberOfWheels);
		} else return "Cannot drive on " + road.toString();
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
