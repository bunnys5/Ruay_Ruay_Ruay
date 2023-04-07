package MainAll;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Procuremen.DAO;

public class MainAll {
	
	static DefaultTableModel tableModel;
	private static JTable table;
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Mini supplier");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(950,750));
		
		
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel("REPORT");
        label.setBounds(430, 30, 100, 30);
        frame.add(label);

        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 110, 827, 327);
		table = new JTable();
		frame.add(scrollPane);
		String[] columnNames = {"ID", "SUPPLIER", "GOOD","QUANTITY", "ORDER DATE", "RECEIVE DATE"};
		tableModel = new DefaultTableModel(columnNames, 0);
		
		DAO.showDataTable(tableModel);
		table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(533);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		
		scrollPane.setViewportView(table);
        
        
		frame.getContentPane().add(new MyMenu(frame), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
