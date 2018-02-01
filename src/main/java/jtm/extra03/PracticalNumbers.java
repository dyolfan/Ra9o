package jtm.extra03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.mysql.fabric.xmlrpc.base.Array;

import java.util.AbstractList;

public class PracticalNumbers {

	// TODO Read article https://en.wikipedia.org/wiki/Practical_number
	// Implement method, which returns practical numbers in given range
	// including
	public String getPracticalNumbers(int from, int to) {
		return "";
	}

	
	static public boolean isPartical(int number) {
		TreeSet<Integer> devision = new TreeSet<>();
		TreeSet<Integer> parts = new TreeSet<>();
		List<Integer> missing = new ArrayList<>();
		
		// Creating division array
		for (int i = 1; i <= number/2; i++)
			if(number%i == 0)
				devision.add(i);
		
		// getting highest number
		int highestNumber = new ArrayList<>(devision).get(devision.size()-1);
		
		//creating Missing numbers
		for(int i=1; i <= highestNumber; i++) {
			if (!devision.contains(i))
				missing.add(i);
		}
		
		
		int x=-1;
		
		List<Integer> tried = new ArrayList<>();
		
		
		while(tried.equals(devision)){
			int sum = 0;
			for (int i : devision){
				if(!tried.contains(i))
					sum+=i;
			}
			if (x>-1){
				int r = new ArrayList<>(devision).get(x);
			tried.add(r);
			}
			parts.add(sum);
			x++;
		}
		
		if(parts.containsAll(missing)){
			System.out.println(number + " true");
			return true;
		}
		
		else {
			System.out.println(number + " false");
			return false;
		}
		
		
		
	}

	public static int getSumExcept(int index, List<Integer> numbers) {
		int sum=0;
		for(int i = 0; i < numbers.size(); i++)
			if(i!=index)
				sum+=numbers.get(i);
		return sum;
	}
	
	public static void main(String[] args) {
		
		List<Integer> devision = new LinkedList<>();
		for (int i = 1; i <=24/2; i++)
			if(24%i == 0)
				devision.add(i);
		
		
		
		
		System.out.print(getSumExcept(1, devision));
		
//		isPartical(12);
//		isPartical(16);
//		isPartical(24);
//		isPartical(13);
//		isPartical(19);
//		isPartical(36);
//		isPartical(64);
//		isPartical(65);
//		isPartical(66);
	}
}