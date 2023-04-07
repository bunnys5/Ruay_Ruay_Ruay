package Procuremen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Procuremen.CatagoryItem;
import Procuremen.DAO;


public class OrderGoods extends JPanel implements ActionListener {

	int idLv1;

	int idLv2;

	int idLv3;
	DefaultTableModel tableModel;
	
	JComboBox<CatagoryItem> lv1ComboBox, lv2ComboBox;
	CatagoryItem selectedCode;

	JTextField quantityTxt;
	JTextField orderDateTxt;
	
	
	JLabel goodLabel;
	JLabel quantityLabel;
	JLabel orderDateLabel;
	

	private static final String addString = "Add";
	private static final String cancelString = "cancel";
	private JTable table;
	

	public OrderGoods(JFrame jframe) {
		
		// Create pane as container
		//Container pane = getContentPane();
		// set layout manager to manual
		JPanel pane = this;
		this.setLayout(null);
	    setLayout(null);
	    JLabel label = new JLabel("1:");
	    label.setBounds(0, 0, 0, 0);
	    pane.add(label);
	    lv1ComboBox = new JComboBox<CatagoryItem>();
	    lv1ComboBox.setBounds(308, 46, 100, 30);
	    pane.add(lv1ComboBox);
	    DAO.ComboBoxVL1(lv1ComboBox, 0);
	    lv1ComboBox.addActionListener(this);
	    
	    
	    lv2ComboBox = new JComboBox<CatagoryItem>();
	    lv2ComboBox.setBounds(503, 46, 282, 30);
	    pane.add(lv2ComboBox);
	    DAO.ComboBoxVL2(lv2ComboBox, idLv2);
	    lv2ComboBox.addActionListener(this);
	    
	    
	    
	    JLabel label_1 = new JLabel("2:");
	    label_1.setBounds(0, 0, 0, 0);
	    pane.add(label_1);
	    
	    
	    goodLabel = new JLabel("Goods");
	    goodLabel.setBounds(458, 46, 100, 30);
	    pane.add(goodLabel);
	    
	    quantityLabel = new JLabel("Quantity");
	    quantityLabel.setBounds(458, 101, 100, 30);
	    pane.add(quantityLabel);
	    
	    orderDateLabel = new JLabel("OrderDate");
	    orderDateLabel.setBounds(458, 156, 100, 30);
	    pane.add(orderDateLabel);
	    
//	    goodTxt = new JTextField();
//	    goodTxt.setBounds(503, 46, 282, 30);
//	    pane.add(goodTxt);
	    
	    quantityTxt = new JTextField();
	    quantityTxt.setBounds(503, 101, 100, 30);
	    pane.add(quantityTxt);
	    
	    orderDateTxt = new JTextField();
	    orderDateTxt.setBounds(503, 156, 100, 30);
	    pane.add(orderDateTxt);
	    

	 

		// create labels
		JLabel addgoodlabel = new JLabel("Add Orders");


		// create buttons
		JButton addBtn = new JButton(addString);
		addBtn.setBackground(new Color(0, 255, 128));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 128));

		// create texts

		
		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		this.add(addgoodlabel);
		
		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addgoodlabel.getPreferredSize();
		addgoodlabel.setBounds(422, 13, 77, 14);
		

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(503, 197, 63, 23);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(600, 197, 77, 23);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 248, 827, 327);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("refresh");
		btnNewButton.setBackground(new Color(0, 255, 128));
		
		
		String[] columnNames = {"ID", "SUPPLIER","GOOD", "QUANTITY", "ORDERDATE", "RECEIVEDATE"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
        DAO.showDataTable(tableModel);
        table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(460);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(97);

		setVisible(true);

		System.out.println("AddformDialog() done!");

	}
	
	public static void infoMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		Object source = e.getSource();
		
		try {
			if(source == lv1ComboBox) {
				System.out.println("lvComboBox");
				selectedCode = (CatagoryItem) lv1ComboBox.getSelectedItem();
				idLv1 = selectedCode.getId();
				System.out.println(idLv1);
				
			} else if(source == lv2ComboBox) {
				System.out.println("lv2ComboBox");
				selectedCode = (CatagoryItem) lv2ComboBox.getSelectedItem();
				idLv2 = selectedCode.getId();
				System.out.println(idLv2);
			} else if(actionCommand.equals(addString)) {
				if(quantityTxt.getText().isEmpty() || orderDateTxt.getText().isEmpty()) {
					infoMessage("Please complete he information.", "Check your fucking fields!");
				} else {
					try {
						int quantity = Integer.parseInt(quantityTxt.getText());
						String orderDate = orderDateTxt.getText();
						
						tableModel.setRowCount(0);
						Order CatagoryOj = new Order(0, idLv1, idLv2, quantity, orderDate);
						DAO.addOrdered(CatagoryOj);
						DAO.showDataTable(tableModel);
						table.setModel(tableModel);
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}


	
		
	


