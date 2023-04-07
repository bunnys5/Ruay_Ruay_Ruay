package Procuremen;

public class Order {
	
	int id;
	int supplier;
	int good;
	int quantity;
	String orderDate;
	public Order(int id, int supplier, int good, int quantity, String orderDate) {
		this.supplier = supplier;
		this.good = good;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}
	public String toString() {
		return "supplier:" + supplier + ", good:" + good +", quantity:" + quantity +", OrderDate:" + orderDate; 
	}

}
