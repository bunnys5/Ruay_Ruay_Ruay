package Constr;

public class Analisys {
	public int id;
	public String ordate;
	public String name;
	public String unit_price;
	public String qty;
	public String tp;
	public Analisys(int id, String ordate, String name, String unit_price, String qty, String tp) {
		this.id = id;
		this.ordate = ordate;
		this.name = name;
		this.unit_price = unit_price;
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
	
	public String getunit_price() {
		return unit_price;
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