package SupplierAdmin;

public class AdminSupplier {
	
	String id;
	String name;
	String address;
	String phone;
	public AdminSupplier(String id, String name, String address, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String toString() {
		return "id:" + id +", name:" + name +", address:" + address  +", phone:" + phone;
	}

}
