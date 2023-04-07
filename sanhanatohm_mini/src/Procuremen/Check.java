package Procuremen;

public class Check {
	
	String id;
	String ReceiveDate;
	public Check(String id,String ReceiveDate) {
		this.id = id;
		this.ReceiveDate = ReceiveDate;
	}
	public String toString() {
		return "name:" + id +", ReceiveDate:" + ReceiveDate;
	}

}
