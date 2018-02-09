package jtm.activity09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/*-  #2
 * Implement Iterator interface with OrderList class
 * Hint! Use generic type argument of iterateable items in form: Iterator<Order>
 * 
 * #3 Override/implement public methods for OrderList class:
 * - OrderList()                — create new empty OrderList
 * - add(Order item)            — add passed order to the OrderList
 * - List<Order> getItemsList() — List of all customer orders				
 * - Set<Order> getItemsSet()   — calculated Set of Orders from list (look at description below)
 * - sort()                     — sort list of orders according to the sorting rules
 * - boolean hasNext()          — check is there next Order in OrderList
 * - Order next()               — get next Order from OrderList, throw NoSuchElementException if can't
 * - remove()                   — remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
 * - String toString()          — show list of Orders as a String
 * 
 * Hints:
 * 1. To convert OrderList to String, reuse .toString() method of List.toString()
 * 2. Use built in List.sort() method to sort list of orders
 * 
 * #4
 * When implementing getItemsSet() method, join all requests for the same item from different customers
 * in following way: if there are two requests:
 *  - ItemN: Customer1: 3
 *  - ItemN: Customer2: 1
 *  Set of orders should be:
 *  - ItemN: Customer1,Customer2: 4
 */

public class OrderList implements Iterator<Order> {
	public int currentOrder;
	public int iter = -1;
	public List<Order> list = null;
	public Order toDelete = null;
	
	
	public OrderList(){
		this.list = new LinkedList<Order>();
		currentOrder = -1;
	}
	
	/*-
	 * #1
	 * Create data structure to hold:
	 *   1. some kind of collection of Orders (e.g. some List)
	 *   2. index to the current order for iterations through the Orders in OrderList
	 *   Hints:
	 *   1. you can use your own implementation or rely on .iterator() of the List
	 *   2. when constructing list of orders, set number of current order to -1
	 *      (which is usual approach when working with iterateable collections).
	 */ 
	
	public void add(Order item) {
		currentOrder++;
		list.add(currentOrder, item);
	}
	
	public List<Order> getItemsList() {
		return this.list;
	}
	
	public Set<Order> getItemsSet() {
		Set<Order> newSet = new TreeSet<Order>();
		
		list.sort(null);
		
		if(list.isEmpty())
			return newSet;
		
		String itemName = list.get(0).toString();
		String customerString;
		Set<String> nameSet = new TreeSet<String>();
		
		for( Order i : list) 
			nameSet.add(i.name);
		
		for (String i : nameSet){
			String setName = i;
			String setCustomer = "";
			int setCount = 0;
			
			for(Order j : list) {
				if (i.equals(j.name)) {
					setCount += j.count;
					setCustomer += j.customer +",";
				}
			}
			setCustomer = setCustomer.substring(0, setCustomer.lastIndexOf(","));
			Order order = new Order(setCustomer, setName, setCount);
			newSet.add(order);
		}
		
		return newSet;
	}
	
	
	@Override
	public boolean hasNext() {
		if (list != null){
			if(list.size() != 0)
			if(list.get(list.size()-1) == null) 
				return false;
			return list.iterator().hasNext();
			}
		else return false;
	}

	@Override
	public Order next() {
		if (!this.hasNext())
			throw new NoSuchElementException();
		iter++;
		toDelete = list.get(iter);
		return list.get(iter);
	}

	@Override
	public void remove() {
		if(toDelete!=null && iter >= 0) {
			list.remove(iter);
			iter--;
			currentOrder--;
		} else throw new IllegalStateException();
		
	}

	public void sort() {
		list.sort(null);
	}
	
	@Override 
	public String toString(){
	String msg = "[";
		for (int i = 0; i < list.size(); i++)
			if(i == list.size() - 1)
				msg += list.get(i).toString();
			else msg += list.get(i).toString() + ", ";
		msg += "]";
		return msg;
	}	
}