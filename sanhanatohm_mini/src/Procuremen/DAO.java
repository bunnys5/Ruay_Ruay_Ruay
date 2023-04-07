package Procuremen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Procuremen.CatagoryItem;
import SupplierAdmin.AdminSupplier;
import AdminGood.Le11ConnMariaDB;



public class DAO {
	
	public static void showDataTableCheck(DefaultTableModel tableModel) {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		
		try {
			String query = "SELECT * FROM ORDERED";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("id");
				String supplier = rs.getString("supplier");
				String good = rs.getString("good");
				String quantity = rs.getString("quantity");
				String orderDate = rs.getString("orderDate");
				String dateReceiveDate = rs.getString("receiveDate");
				
				Object[] row = {id, supplier, good, quantity, orderDate, dateReceiveDate};
				
				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
			
		}catch(SQLException ex) {
			System.out.println("Error! Invalid id.");
			System.out.println(ex.getMessage());
			
		}
	}
	
	
	public static void showDataTable(DefaultTableModel tableModel) {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		
		try {
			String query = "SELECT * from ordered";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("id");
				String supplier = rs.getString("supplier");
				String good = rs.getString("good");
				String quantity = rs.getString("quantity");
				String OrderDate = rs.getString("OrderDate");
				String ReceiveDate = rs.getString("ReceiveDate");

//				System.out.format("%s, %s, %s, %s, %s, %s");
				
				Object[] row = {id, supplier, good, quantity, OrderDate, ReceiveDate};
				
				tableModel.addRow(row);
			}
			st.close();
			rs.close();
			con.close();
			
		}catch (SQLException ex) {
			System.out.println("Error! Invalid id.");
			System.err.println(ex.getMessage());
		}
	}
	
	public static void addOrdered (Order Order)  {
		
		try {
			String insersql = "INSERT INTO ordered (supplier,good,quantity,orderdate,receivedate) VALUES " + "('" + Order.supplier +  "','" + Order.good+ "','"+Order.quantity+"','"+Order.orderDate + "', 'date')";
			
			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();
			
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insersql);
				stmnt.close();
				con.close();
				System.out.println("Goods add successfully.");
			}
			
			
			
			
		} catch (SQLException ex) {
			System.out.println("Error! Invalid id.");
			
		}
	}
	
	public static void ComboBoxVL1 (JComboBox<CatagoryItem> lv1ComboBox, int id) {
		try {

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM supplier ");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				lv1ComboBox.addItem(item);
				
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void ComboBoxVL2 (JComboBox<CatagoryItem> lv2ComboBox, int id) {
		try {

			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM goods_g ");

			while (rs.next()) {

				CatagoryItem item = new CatagoryItem(rs.getString("name"),rs.getInt("id"));
				lv2ComboBox.addItem(item);
				
			}

			st.close();
			rs.close();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void acceptSupplier(Check up) {
        Le11ConnMariaDB connDB = new Le11ConnMariaDB();
        Connection con = connDB.getConnection();
        try {
            String upsql = "UPDATE ORDERED SET RECEIVEDATE='" + up.ReceiveDate + "' WHERE ID ='" + up.id + "'";
            Statement stmnt = null;
            if (con != null) {
                stmnt = con.createStatement();
                stmnt.execute(upsql);
                stmnt.close();
                con.close();
                System.out.println("supplier update successfully.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
	
	
	
	

}
