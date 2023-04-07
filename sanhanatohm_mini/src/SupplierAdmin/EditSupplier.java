package SupplierAdmin;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EditSupplier extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;
	
	int idLv1, idLv2, idLv3;

	DefaultTableModel tableModel;

	JTextField nameTxt;
	JTextField addressTxt;
	JTextField phoneTxt;
	
	private static final String editString = "Edit";
	private static final String refreshString = "refresh";
	
	private JTable table;
	String id1;
	String name1;
	String price1;
	String stock1;

	public EditSupplier(JFrame frame) {

		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel addgoodlabel = new JLabel("Edit Goods");
		JLabel nameLabel = new JLabel("Name");
		JLabel priceLabel = new JLabel("Address");
		JLabel stockLabel = new JLabel("Phone");

		// create buttons
		JButton addBtn = new JButton(editString);
		JButton refreshBtn = new JButton(refreshString);

		// create texts
		nameTxt = new JTextField(20);
		addressTxt = new JTextField(10);
		phoneTxt = new JTextField(10);

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
		addgoodlabel.setBounds(402, 11, 79, 14);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(328, 46, 100, 30);
		size = priceLabel.getPreferredSize();
		priceLabel.setBounds(328, 101, 100, 30);
		size = stockLabel.getPreferredSize();
		stockLabel.setBounds(328, 156, 100, 30);

		// set sizes and positions for labels
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(393, 46, 334, 30);
		size = addressTxt.getPreferredSize();
		addressTxt.setBounds(393, 101, 100, 30);
		size = phoneTxt.getPreferredSize();
		phoneTxt.setBounds(393, 156, 100, 30);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(351, 196, 67, 23);
		size = refreshBtn.getPreferredSize();
		refreshBtn.setBounds(438, 196, 79, 23);

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

			if(command.equals(editString)) {
				System.out.println("actionCommand:" + editString);
				if((nameTxt.getText().isEmpty()) || addressTxt.getText().isEmpty() || phoneTxt.getText().isEmpty()) {
					AlertMessage.infoMessage("Please complete the information.", "Alert");
				} else {
				try {
					
					String name = nameTxt.getText();
					String address = addressTxt.getText();
					String phone = phoneTxt.getText();
					AdminSupplier EDIT = new AdminSupplier(id1, name, address, phone);
					System.out.println("Admingoods2:" + editString.toString());
					DAO.editSupplier(EDIT);
					tableModel.setRowCount(0);
			           DAO.showDataTable(tableModel);
			           table.setModel(tableModel);
			         						
				}catch (Exception ex) {
	                System.err.println("Error! Invalid data.");
	            }
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
