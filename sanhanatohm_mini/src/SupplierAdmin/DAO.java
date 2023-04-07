package SupplierAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DAO {
	
	public static void showDataTable(DefaultTableModel tableModel) {
		Le11ConnMariaDB connDB = new Le11ConnMariaDB();
		Connection con = connDB.getConnection();
		
		try {
			String query = "SELECT * FROM supplier";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");


//				System.out.format("%s, %s, %s, %s");
				
				Object[] row = {id, name, address, phone};
				
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
	
	public static void addSupplier (AdminSupplier supplier) {
		try {
			String insertsql = "INSERT INTO supplier (NAME, ADDRESS, PHONE) VALUES " + "('" + supplier.name + "','" + supplier.address + "','" + supplier.phone + "')";
			
			Le11ConnMariaDB connDB = new Le11ConnMariaDB();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertsql);
				stmnt.close();
				con.close();
				System.out.println("Supplier add successfully.");
			}
		} catch (SQLException ex) {
			System.out.println("Error! Invalid data.");
		}
	}
	
	public static void editSupplier(AdminSupplier up) {
        Le11ConnMariaDB connDB = new Le11ConnMariaDB();
        Connection con = connDB.getConnection();
        try {
            String upsql = "UPDATE SUPPLIER SET NAME='" + up.name + "', ADDRESS='" + up.address + "', PHONE='" + up.phone + "' WHERE ID=" + up.id;
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
	
	public static void deleteSupplier(AdminSupplier up) {
        Le11ConnMariaDB connDB = new Le11ConnMariaDB();
        Connection con = connDB.getConnection();
        try {
            String upsql = "DELETE FROM SUPPLIER WHERE ID=" + up.id;
            Statement stmnt = null;
            if (con != null) {
                stmnt = con.createStatement();
                stmnt.execute(upsql);
                stmnt.close();
                con.close();
                System.out.println("supplier delete successfully.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
