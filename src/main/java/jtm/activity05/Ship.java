package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {

	protected byte numberOfSails;
	
	public Ship(String id, float consumption, int tankSize) {
		super(id, consumption, tankSize);
	}
	
	public Ship(String id, byte sails) {
		super(id);
		this.numberOfSails = sails;
	}

	@Override
	public String move(Road road) {
		if(road instanceof WaterRoad)
		return String.format("%s is sailing on %s with %d sails",
				this.getType(), road.toString(), numberOfSails);
		else return String.format("Cannot sail on %s",
								road.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
