package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {

	protected byte numberOfSails;

	public Ship(String id, byte sails) {
		super(id);
		this.numberOfSails = sails;
	}

	public Ship(String id, float consumption, int tankSize) {
		super(id, consumption, tankSize);
	}

	@Override
	public String move(Road road) {
		if (road instanceof WaterRoad)
			return String.format("%s is sailing on %s with %d sails", this.getType(), road.toString(), numberOfSails);
		else
			return String.format("Cannot sail on %s", road.toString());
	}
	
}
