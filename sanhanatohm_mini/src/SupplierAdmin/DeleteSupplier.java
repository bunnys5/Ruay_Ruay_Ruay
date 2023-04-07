package SupplierAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import SupplierAdmin.DAO;
import SupplierAdmin.AdminSupplier;

public class DeleteSupplier extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;
	
	int idLv1, idLv2, idLv3;

	DefaultTableModel tableModel;

	JLabel nameTxt;
	JLabel addressTxt;
	JLabel phoneTxt;

	private static final String deleteString = "Delete";
	private static final String refreshString = "Refresh";

	private JTable table;
	String id1;
	String name1;
	String price1;
	String stock1;

	public DeleteSupplier(JFrame frame) {

		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel addgoodlabel = new JLabel("Delete Supplier");
		JLabel nameLabel = new JLabel("Name");
		JLabel priceLabel = new JLabel("Address");
		JLabel stockLabel = new JLabel("Phone");

		// create buttons
		JButton addBtn = new JButton(deleteString);
		JButton refreshBtn = new JButton(refreshString);

		// create texts
		nameTxt = new JLabel();
		addressTxt = new JLabel();
		phoneTxt = new JLabel();

		// create control buttons.
		addBtn.addActionListener(this);
		refreshBtn.addActionListener(this);
		setLayout(null);

		// add labels
		pane.add(addgoodlabel);
		pane.add(nameLabel);
		pane.add(priceLabel);
		pane.add(stockLabel);

		// add text fields
		pane.add(nameTxt);
		pane.add(addressTxt);
		pane.add(phoneTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(refreshBtn);

		// set sizes and positions for labels
		Dimension size = addgoodlabel.getPreferredSize();
		addgoodlabel.setBounds(434, 4, 81, 14);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(316, 39, 100, 30);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(316, 94, 100, 30);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(316, 149, 100, 30);

		// set sizes and positions for labels
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(396, 39, 300, 30);
		size = addressTxt.getPreferredSize();
		addressTxt.setBounds(396, 94, 100, 30);
		size = phoneTxt.getPreferredSize();
		phoneTxt.setBounds(396, 149, 100, 30);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(383, 189, 72, 23);
		size = refreshBtn.getPreferredSize();
		refreshBtn.setBounds(476, 189, 88, 23);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 248, 827, 327);
		this.add(scrollPane);
		
		String[] columnNames = {"ID", "NAME", "ADDRESS","PHONE"};
		tableModel = new DefaultTableModel(columnNames, 0);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0 ) {
					id1 = tableModel.getValueAt(row, 0).toString();
					name1 = tableModel.getValueAt(row, 1).toString();
					price1 = tableModel.getValueAt(row, 2).toString();
					stock1 = tableModel.getValueAt(row, 3).toString();
					nameTxt.setText(name1);
					addressTxt.setText(price1);
					phoneTxt.setText(stock1);
				}
				
			}
			
		});
		
		DAO.showDataTable(tableModel);
		table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(533);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);

		scrollPane.setViewportView(table);
		
		setVisible(true);

		System.out.println("AddformDialog() done!");

		
	}

	@Override
	// TODO Auto-generated method stub
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		Object source = e.getSource();

		try {

			if(command.equals(deleteString)) {
				System.out.println("actionCommand:" + deleteString);
				try {
					
					String name = nameTxt.getText();
					String address = addressTxt.getText();
					String phone = phoneTxt.getText();
	
					AdminSupplier EDIT = new AdminSupplier(id1, name, address, phone);
					System.out.println("Admingoods2:" + deleteString.toString());
					DAO.deleteSupplier(EDIT);
					tableModel.setRowCount(0);
			           DAO.showDataTable(tableModel);
			           table.setModel(tableModel);
			           
			           nameTxt.setText(null);
			           addressTxt.setText(null);
			           phoneTxt.setText(null);


				}catch (Exception ex) {
	                System.err.println("Error! Invalid data.");
	            }
			}else if(command.equals(refreshString)) {
				tableModel.setRowCount(0);
		           DAO.showDataTable(tableModel);
		           table.setModel(tableModel);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

