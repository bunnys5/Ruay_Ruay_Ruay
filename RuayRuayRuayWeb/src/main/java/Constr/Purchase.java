package Constr;

public class Purchase {
	    public String gid;
	    public String qty;
	    
	    
	    public Purchase(String gid,String qty) {

	    	this.gid = gid;
	    	this.qty = qty;
	    }
	    

		public void setGID(String gid) {
			this.gid = gid;
			
		}
		
		public void setQTY(String qty) {
			
			this.qty = qty;
		}
		

		public String getGID() {
			
			return gid;
		}
		
		public String getQTY() {
			
			return qty;
		}




}