package jtm.activity04;

public class TrafficManagementSystem {
	static Road[] roads;
	static Transport[] transports;

	public static void addRoads(int i) {
		// create new array of roads in size of passed value
		roads = new Road[i];
	}

	public static void addTransport(int i) {
		// create new array of transports in size of passed value
		transports = new Transport[i];
	}

	public static Road[] getRoads() {
		// return required value
		return roads;
	}

	public static Transport[] getTransports() {
		// return required value
		return transports;
	}

	/**
	 * This method is called to set up TransportManagementSystem
	 * 
	 * @param roads
	 * @param transport
	 */

	public static void initSystem(int roads, int transport) {
		addRoads(roads);
		addTransport(transport);
	}

	public static void setRoad(Road road, int i) {
		// set passed road into passed cell of roads array
		roads[i] = road;
	}

	public static void setVehicle(Transport transport, int i) {
		// set passed transport into transports array cell of passed index
		transports[i] = transport;
	}

}
