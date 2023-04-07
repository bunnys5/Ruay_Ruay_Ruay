package Procuremen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Procuremen.DAO;

public class CheckGoods extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField ReceiveDateTxt;
	DefaultTableModel tableModel;
	
	JLabel supplierTxt;
	JLabel goodTxt;
	JLabel quantityTxt;
	JLabel orderDateTxt;
	
	String supplierGet;
	String goodGet;
	String quantityGet;
	String orderDateGet;
	String dateReceiveGet;
	
	JLabel nameLabel_1;
	JLabel goodLabel_1;
	JLabel quantityLabel_1;
	JLabel orderDateLabel_1;
	
	String idGet;
	
	

	private static final String acceptString = "accept";
	private static final String cancelString = "cancel";
	private JTable table;

	public CheckGoods(JFrame frame) {
//		super(frame, true);
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				ShowData();
//			}
//		});

		// Create pane as container
//		Container pane = getContentPane();
		// set layout manager to manual
		JPanel pane = this;
		pane.setLayout(null);

		// create labels
		JLabel chacklabel = new JLabel("Chack Order");
		chacklabel.setBounds(412, 11, 90, 14);
		JLabel nameLabel = new JLabel("Supplier");
		nameLabel.setBounds(314, 33, 54, 14);
		JLabel goodLabel = new JLabel("Goods");
		goodLabel.setBounds(314, 74, 42, 14);
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setBounds(314, 112, 100, 30);
		JLabel orderDateLabel = new JLabel("Order Date");
		orderDateLabel.setBounds(314, 162, 100, 30);
		JLabel ReceiveDateLabel = new JLabel("ReceiveDate");
		ReceiveDateLabel.setBounds(647, 74, 61, 14);

		
		nameLabel_1 = new JLabel();
		nameLabel_1.setBounds(527, 33, 54, 14);
		add(nameLabel_1);
		
		goodLabel_1 = new JLabel();
		goodLabel_1.setBounds(527, 74, 42, 14);
		add(goodLabel_1);
		
		quantityLabel_1 = new JLabel();
		quantityLabel_1.setBounds(527, 112, 100, 30);
		add(quantityLabel_1);
		
		orderDateLabel_1 = new JLabel();
		orderDateLabel_1.setBounds(527, 162, 100, 30);
		add(orderDateLabel_1);
		
		// create buttons
		JButton acceptBtn = new JButton(acceptString);
		acceptBtn.setBounds(383, 204, 90, 23);
		acceptBtn.setBackground(new Color(0, 255, 64));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBounds(504, 204, 90, 23);
		cancelBtn.setBackground(new Color(0, 255, 64));

		// create texts
		supplierTxt = new JLabel();
		goodTxt = new JLabel();
		goodTxt.setBounds(0, 0, 0, 0);
		quantityTxt = new JLabel();
		quantityTxt.setBounds(0, 0, 0, 0);
		orderDateTxt = new JLabel();
		orderDateTxt.setBounds(0, 0, 0, 0);
		ReceiveDateTxt = new JTextField(10);
		ReceiveDateTxt.setBounds(622, 117, 120, 20);

		// create control buttons.
		acceptBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		setLayout(null);

		// add labels
		pane.add(chacklabel);
		pane.add(nameLabel);
		pane.add(goodLabel);
		pane.add(quantityLabel);
		pane.add(orderDateLabel);
		pane.add(ReceiveDateLabel);

		// add text fields
		pane.add(ReceiveDateTxt);
		pane.add(goodTxt);
		pane.add(quantityTxt);
		pane.add(orderDateTxt);

		// add control buttons
		pane.add(acceptBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = chacklabel.getPreferredSize();
		size = nameLabel.getPreferredSize();
		size = ReceiveDateLabel.getPreferredSize();
		size = goodLabel.getPreferredSize();
		size = quantityLabel.getPreferredSize();
		size = orderDateLabel.getPreferredSize();

		// set sizes and positions for labels

		size = ReceiveDateTxt.getPreferredSize();

		// set sizes and positions for controls buttons
		size = acceptBtn.getPreferredSize();
		size = cancelBtn.getPreferredSize();

		// set size and position for container
		pane.setPreferredSize(new Dimension(510, 500));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 248, 827, 327);
		table = new JTable();
		this.add(scrollPane);
		String[] columnNames = {"ID", "SUPPLIER", "GOOD","QUANTITY", "ORDER DATE", "RECEIVE DATE"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row >= 0 ) {
					idGet = tableModel.getValueAt(row, 0).toString();
					supplierGet = tableModel.getValueAt(row, 1).toString();
					goodGet = tableModel.getValueAt(row, 2).toString();
					quantityGet = tableModel.getValueAt(row, 3).toString();
					orderDateGet = tableModel.getValueAt(row, 4).toString();
					dateReceiveGet = tableModel.getValueAt(row, 5).toString();
					
					nameLabel_1.setText(supplierGet);
					goodLabel_1.setText(goodGet);
					quantityLabel_1.setText(quantityGet);
					orderDateLabel_1.setText(orderDateGet);
					ReceiveDateTxt.setText(dateReceiveGet);
					
					
					
				}
				
			}
			
		});
//		
		
		DAO.showDataTableCheck(tableModel);
		table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(533);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		
		
		scrollPane.setViewportView(table);
		
//		pack();
//		setLocationRelativeTo(null);
		setVisible(true);

		System.out.println("AddformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String actionCommand = evt.getActionCommand();
		// user presses "Add"
		if (actionCommand.equals(acceptString)) {
			System.out.println("actionCommand:" + acceptString);
			try {

				String receiveDate = ReceiveDateTxt.getText();
				
				Check order = new Check(idGet, receiveDate);
				DAO.acceptSupplier(order);

				tableModel.setRowCount(0);
		           DAO.showDataTableCheck(tableModel);
		           table.setModel(tableModel);
				
				
				
		
			}catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
		}else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
	}
}
	

