package jtm.activity11;

import java.util.LinkedList;

/**
 * This is frontend class for array filler. It uses ArrayFiller to fill array of
 * integers using sequental or concurrent (parallel) approach
 */
public class ArrayFillerManager {
	static int[] array; // array to be filled
	static int latency; // emulated latency in ms
	static int minValue, maxValue; // min and max (including) of the
									// array cell
	static LinkedList<Thread> threads; // list of threads when parallel
										// filling is used

	// HINT feel free to use main() method to call setUp(), fillStupidly() etc.
	// for debugging purposes if unit tests doesn't show enough information,
	// what exactly in implementation seems wrong.
	// Note that main() method will not be used in unit tests.

	public static void fillParalelly() {
		// TODO create cycle which creates new ArrayFiller objects
		// with any range and pass them as references to the Thread constructor.
		// Add newly created Thread objects into threads list and start them
		// threads using .start() method. Note that invocation of .start() for
		// thread object creates new concurrent thread in application
		// Note that, to pass tests, this implementation should run faster than
		// fillSequentally() method.
		//
		// HINT: Don't forget to check that separately started threads are
		// actually finished by calling .join() method for them.
		// Note that this method emulates, what would happen if you do proper
		// buffering and scaling of the execution.                                           Use notify.

		System.out.println("*****PARALEL********");
		
		ArrayFiller filler1 = new ArrayFiller(latency, minValue, maxValue, 0, array.length * 1/8 -1);
		ArrayFiller filler2 =  new ArrayFiller(latency, minValue, maxValue, array.length * 1/8, array.length/4 -1);
		ArrayFiller filler3 = new ArrayFiller(latency, minValue, maxValue, array.length/4, array.length/2 -1);
		ArrayFiller filler4 = new ArrayFiller(latency, minValue, maxValue, array.length/2, array.length-1);
		
		Thread t1 = new Thread(filler1);
		Thread t2 = new Thread(filler2);
		Thread t3 = new Thread(filler3);
		Thread t4 = new Thread(filler4);
		
		threads.add(t1);
		threads.add(t2);
		threads.add(t3);
		
		filler4.run();
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			  e.printStackTrace();
		}
	}

	public static void fillSequentially() {
		//  create cycle which creates one ArrayFiller object
		// with filling range for ALL array but executed just in SINGLE thread
		// by invocation of .run() method directly.
		// Note that this method emulates, what would happen if you would do
		// proper "buffering" with large amount of data, but do execution just
		// in single thread.
		System.out.println("*****SEQUENT********");
		ArrayFiller filler = new ArrayFiller(latency, minValue, maxValue, 0, ArrayFillerManager.array.length-1);
		filler.run();
	}
	
	public static void fillStupidly() {
		// create cycle which creates new ArrayFiller objects
		// with filling range of only ONE cell at a time (i.e. range from..to is
		// 0..0, then 1..1, etc.) and invoke .run() method for these objects.
		// Note, that invocation of .run() method directly executes it in
		// current (main) thread.
		// Note that this method emulates, what would happen if you would send
		// just small portions of data through media with latency.
		System.out.println("*****STUPID********");
		for ( int i = 0; i < ArrayFillerManager.array.length; i++) {
			ArrayFiller filler = new ArrayFiller(latency, minValue, maxValue, i, i);
			filler.run();
		}
		
		
	}

	public static int[] setUp(int arraySize, int latency, int minValue, int maxValue) {
		// save passed values in prepared structure
		// initialize array with passed size
		// initialize list of threads
		// return reference to the initialized array
		
		ArrayFillerManager.latency = latency;
		ArrayFillerManager.minValue = minValue;
		ArrayFillerManager.maxValue = maxValue;
		
		threads = new LinkedList<>();
		
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Thread t3 = new Thread();
		Thread t4 = new Thread();
		
		ArrayFillerManager.threads.add(t1);
		ArrayFillerManager.threads.add(t2);
		ArrayFillerManager.threads.add(t3);
		ArrayFillerManager.threads.add(t4);
		
		array = new int[arraySize];
		return array;
	}
}