package SupplierAdmin;

import javax.swing.JOptionPane;

public class AlertMessage {
	public static void infoMessage (String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

}
