package Constr;

public class OrderReport {
	public int id;
	public String ordate;
	public String name;
	public String qty;
	public String tp;

	public OrderReport(int id, String ordate, String name, String qty, String tp) {
		this.id = id;
		this.ordate = ordate;
		this.name = name;
		this.qty = qty;
		this.tp = tp;
	}

	public int getid() {
		return id;
	}

	public String getordate() {
		return ordate;
	}

	public String getName() {
		return name;
	}

	public String getqty() {
		return qty;
	}

	public String gettp() {
		return tp;
	}

	public String toString() {
		return id + ordate  + name + qty + tp;
	}

	public int getfor() {
		int count = 0;
		for (int i = 0; i <= id; i++) {
			count = i;
		}
		return count;
	}
}
