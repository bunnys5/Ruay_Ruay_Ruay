package Constr;

public class goods {
	public int id;
	public  String lv3;
	public  String lv2;
	public  String lv1;
	public  String name;
	public  int unit_price;
	public  int stocks;

	public goods(int id, String lv3, String lv2, String lv1, String name, int unit_price, int stocks) {
		this.id = id;
		this.lv3= lv3;
		this.lv2 = lv2;
		this.lv1 = lv1;
		this.name = name;
		this.unit_price = unit_price;
		this.stocks = stocks;
	}
	

	public int getid() {
		return id;
	}
	

	public String getlv1() {
		return lv1;
	}
	

	public String getlv2() {
		return lv2;
	}
	

	public String getlv3() {
		return lv3;
	}
	

	
	public String getName() {
		return name;
	}
	

	
	public int getPrice() {
		return unit_price;
	}
	

	
	public int getStocks() {
		return stocks;
	}
	
	public  String toString() {
		return  id+lv1+lv2+lv3+name;
	}
	


	public int getfor() {
		int count = 0;
		for(int i =0 ; i<=id; i++) {
			count = i;
		}
		return count;
	}
}

