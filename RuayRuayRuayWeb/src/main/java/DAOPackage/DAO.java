package DAOPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Constr.Purchase;
import Constr.goods;
import Constr.Analisys;
import Constr.MonthYear;
import Constr.SalesReport;
import Constr.OrderReport;


public class DAO {
	
	public static List<goods> getGoods() {
		List<goods> list = new ArrayList<goods>();

		try {
			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"SELECT goods_g.id,c_l1.nameL1,c_l2.nameL2,c_l3.nameL3,goods_g.name,goods_g.unit_price,goods_g.stocks FROM goods_g LEFT JOIN c_l1 ON goods_g.lv1=c_l1.id LEFT JOIN c_l2 ON goods_g.lv2=c_l2.id LEFT JOIN c_l3 ON goods_g.lv3=c_l3.id");
			ResultSet rs = ps.executeQuery();

			
			
			
			while (rs.next()) {

				int id = rs.getInt("id");
				String lv3 = rs.getString("nameL3");
				String lv2 = rs.getString("nameL2");
				String lv1 = rs.getString("nameL1");
				String name = rs.getString("name");
				int unp = rs.getInt("unit_price");
				int sto = rs.getInt("stocks");

				goods g = new goods(id, lv3, lv2, lv1, name, unp, sto);
				list.add(g);

			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return list;

	}
	
public static void AddSalesAndUpdateStock(Purchase purchase) {

		try {
			
			LocalDate ReceiveDate = LocalDate.now();
			DateTimeFormatter formatRD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String ordate = ReceiveDate.format(formatRD);
	
	
			ZoneId zone = ZoneId.of("Asia/Bangkok");  
    		ZonedDateTime currentTime = ZonedDateTime.now(zone);
			String time = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			
			
			String insertSql = "INSERT INTO receipt  (ordate,gid,qty)  VALUES" + "('"+ordate + "',"+purchase.gid+","+purchase.qty+")";
			System.out.println("insertSql:" + insertSql);
			String UpdateSql = "UPDATE goods_g,receipt SET goods_g.stocks = goods_g.stocks - receipt.qty WHERE goods_g.id = receipt.gid ORDER BY receipt.id DESC LIMIT 1 ";
			


			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.execute(UpdateSql);
				stmnt.close();
				con.close();
				System.out.println("Goods added successfully.");
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

public static List<Analisys> getAnalisys() {
	List<Analisys> list = new ArrayList<Analisys>();

	try {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		

		String query = "SELECT receipt.id,receipt.ordate,goods_g.name,goods_g.unit_price,receipt.Qty,goods_g.unit_price*receipt.Qty AS total_price FROM receipt LEFT JOIN goods_g ON receipt.gid=goods_g.id WHERE ordate";

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			int id = rs.getInt("id");
			String ordate = rs.getString("ordate");
			String name = rs.getString("name");
			String unit_price = rs.getString("unit_price");
			String qty = rs.getString("Qty");
			String tp = rs.getString("total_price");

			Analisys sp = new Analisys(id, ordate, name, unit_price, qty, tp);

			list.add(sp);
			
			

		}
	} catch (Exception e) {
		System.err.println(e);
	}

	return list;

}

public static List<Analisys> getAnalisysSelected(MonthYear my) {
	List<Analisys> list = new ArrayList<Analisys>();

	try {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();


		String query = "SELECT receipt.id,receipt.ordate,goods_g.name,goods_g.unit_price,receipt.Qty,goods_g.unit_price*receipt.Qty AS total_price FROM receipt LEFT JOIN goods_g ON receipt.gid=goods_g.id WHERE ordate LIKE '%"+my.my+"%' ORDER BY receipt.ordate";

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			int id = rs.getInt("id");
			String ordate = rs.getString("ordate");
			String name = rs.getString("name");
			String unit_price = rs.getString("unit_price");
			String qty = rs.getString("Qty");
			String tp = rs.getString("total_price");

			Analisys sp = new Analisys(id, ordate, name, unit_price, qty, tp);

			list.add(sp);
			
			

		}
	} catch (Exception e) {
		System.err.println(e);
	}

	return list;

}

public static List<OrderReport> getOrderReport() {
	List<OrderReport> list = new ArrayList<OrderReport>();

	try {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();

		String query = "SELECT receipt.id,receipt.ordate,goods_g.name,goods_g.unit_price,receipt.Qty,goods_g.unit_price*receipt.Qty AS total_price FROM receipt LEFT JOIN goods_g ON receipt.gid=goods_g.id ORDER BY receipt.ordate ";

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			int id = rs.getInt("id");
			String ordate = rs.getString("ordate");
			String name = rs.getString("name");
			String qty = rs.getString("Qty");
			String tp = rs.getString("total_price");

			OrderReport sp = new OrderReport(id, ordate, name, qty, tp);

			list.add(sp);

		}
	} catch (Exception e) {
		System.err.println(e);
	}

	return list;

}

public static List<SalesReport> getSalesReport(){
	List<SalesReport> list = new ArrayList<SalesReport>();
	try {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		
		String query = "SELECT year(ordate)AS year ,date_format(ordate,'%M') AS month ,SUM(Qty) AS totalSales FROM `receipt` group by year(ordate),month(ordate) order by year(ordate),month(ordate)";
		
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			String year = rs.getString("year");
			String month = rs.getString("month");
			String sumsale = rs.getString("totalSales");
			
			SalesReport sp = new SalesReport(year,month,sumsale);
			
			list.add(sp);
		}

	}catch (Exception e) {
		System.err.println(e);
	}
	return list;
}
}



