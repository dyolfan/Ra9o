package jtm.activity09;

/*-
 * Implement Comparable interface with Order class
 * Hint! Use generic type of comparable items in form: Comparable<Order>
 * 
 * TODO #2 Override/implement necessary methods for Order class:
 * - Order(String orderer, String itemName, Integer count) — constructor of the Order
 * - int compareTo(Order order) — comparison implementation according to logic described below
 * - boolean equals(Object object) — check equality of orders
 * - int hashCode() — to be able to handle it in some hash... collection 
 * - String toString() — string in following form: "ItemName: OrdererName: Count"
 * 
 * Hints:
 * 1. When comparing orders, compare their values in following order:
 *    - Item name
 *    - Customer name
 *    - Count of items
 * If item or customer is closer to start of alphabet, it is considered "smaller"
 * 
 * 2. When implementing .equals() method, rely on compareTo() method, as for sane design
 * .equals() == true, if compareTo() == 0 (and vice versa).
 * 
 * 3. Also Ensure that .hashCode() is the same, if .equals() == true for two orders.
 * 
 */

public class Order implements Comparable<Order> {
	String name;
	String customer;
	int count;

	public Order(String orderer, String itemName, Integer count) {
		this.customer = orderer;
		this.name = itemName;
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (count != other.count) {
			return false;
		}
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(Order arg0) {
//		Order comp = (Order) arg0;
//		if (this.equals(arg0))
//			return 0;
//		if (this.name != comp.name)
//			if (this.name.compareTo(comp.name) < 0)
//				return -1;
//			else return 1;
//		if (this.customer != comp.customer)
//			if (this.customer.compareTo(comp.customer) < 0)
//				return -1;
//			else return 1;
//		if (Integer.compare(this.count, comp.count) < 0)
//			return -1;
//		if (Integer.compare(this.count, comp.count) > 0)
//			return 1;
//		return 0;
		if(this.customer.equals(arg0.customer)  && this.name.equals(arg0.name) && this.count == arg0.count){
			return 0;
	} else if (this.customer.compareTo(arg0.customer) < 0 || this.name.compareTo(arg0.name) < 0|| this.count < arg0.count) {
		return -1;
	} else {
		return 1;
	}
		
	}

	@Override
	public String toString() {
		return name + ": " + customer + ": " + count;
	}	
}