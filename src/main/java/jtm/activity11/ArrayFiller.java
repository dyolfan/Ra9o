package jtm.activity11;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayFiller implements Runnable {

	int from, to; // range which should be filled by this filler
					int latency; // required latency time (in miliseconds) to simulate real
	// environment
	int minValue, maxValue; // min and max allowed values for array cells
	Random random; // Pseudo-random generator

	public ArrayFiller(int latency, int minValue, int maxValue) {
		// from this constructor call another constructor with more
		// parameters and fill missing
		// values with fixed literals
		
		this.latency = latency;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.from = 0;
		this.to = ArrayFillerManager.array.length-1;
		
	}

	public ArrayFiller(int latency, int minValue, int maxValue, int from, int to) {
		// save passed values to created filler object
		// Create and initialize pseudo-random generator. See more at:
		// http://docs.oracle.com/javase/7/docs/api/java/util/Random.html
		
		this(latency, minValue, maxValue);
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		// when invoked, put filler to sleep for required amount of latency
		// then fill ArrayFillerManager.array from..to cells with random values
		// in
		// minValue..maxValue range
		
		try {
			Thread.sleep(latency);
			for ( int i = from; i <= to; i ++) {
				int x = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
				ArrayFillerManager.array[i] = x;
				System.out.println(x);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
