package SupplierAdmin;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import SupplierAdmin.DAO;

public class AddSupplier extends JPanel implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;


	JTextField nameTxt;
	JTextField addressTxt;
//	JTextField provinceTxt;
	JTextField phoneTxt;
	JButton addBtn;
	
	String name;
	String address;
	String phone;

	private static final String addString = "Add";
	private static final String cancelString = "cancel";
	private JTable table;
	DefaultTableModel tableModel;

	public AddSupplier(JFrame frame) {
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
		JLabel addSupplierlabel = new JLabel("Add Supplier");
		JLabel nameLabel = new JLabel("Name");
		JLabel addressLabel = new JLabel("Address");
//		JLabel provinceLabel = new JLabel("Province");
		JLabel phoneLabel = new JLabel("Phone");

		// create buttons
		JButton addBtn = new JButton(addString);
		addBtn.setBackground(new Color(0, 255, 64));
		JButton cancelBtn = new JButton(cancelString);
		cancelBtn.setBackground(new Color(0, 255, 64));

		// create texts

		nameTxt = new JTextField(20);
		addressTxt = new JTextField(15);
//		provinceTxt = new JTextField(10);
		phoneTxt = new JTextField(10);

		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		setLayout(null);

		// add labels
		pane.add(addSupplierlabel);
		pane.add(nameLabel);
		pane.add(addressLabel);
//		pane.add(provinceLabel);
		pane.add(phoneLabel);

		// add text fields

		pane.add(nameTxt);
		pane.add(addressTxt);
//		pane.add(provinceTxt);
		pane.add(phoneTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addSupplierlabel.getPreferredSize();
		addSupplierlabel.setBounds(451, 11, 90, 14);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(351, 66, 60, 14);
		size = addressLabel.getPreferredSize();
		addressLabel.setBounds(351, 96, 60, 14);
//		size = provinceLabel.getPreferredSize();
//		provinceLabel.setBounds(70, 120, 41, 14);
		size = phoneLabel.getPreferredSize();
		phoneLabel.setBounds(351, 156, 60, 14);

		// set sizes and positions for labels

		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(421, 66, 120, 20);
		size = addressTxt.getPreferredSize();
		addressTxt.setBounds(421, 96, 120, 20);
//		size = provinceTxt.getPreferredSize();
//		provinceTxt.setBounds(140, 120, 120, 20);
		size = phoneTxt.getPreferredSize();
		phoneTxt.setBounds(421, 156, 120, 20);

		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(374, 196, 60, 23);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(451, 196, 73, 23);

		// set size and position for container
		pane.setPreferredSize(new Dimension(400, 500));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 248, 827, 327);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setBackground(new Color(255, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(534, 196, 83, 23);
		this.add(btnNewButton);
		
		String[] columnNames = {"ID", "NAME","ADDRESS","PHONE"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        DAO.showDataTable(tableModel);
        
        table.setModel(tableModel);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(533);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		
		

		
		setVisible(true);

		System.out.println("AddformDialog() done!");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
				
				try {
					
					if(actionCommand.equals(addString)) {
						if(nameTxt.getText().isEmpty() || addressTxt.getText().isEmpty() || phoneTxt.getText().isEmpty()) {
							AlertMessage.infoMessage("Check your fucking field!", "Please complete the information.");
						} else {
						try {
							name = nameTxt.getText();
							address = addressTxt.getText();
							phone = phoneTxt.getText();
							
							tableModel.setRowCount(0);
							AdminSupplier supplierItem = new AdminSupplier(null, name, address, phone);
							DAO.addSupplier(supplierItem);
							DAO.showDataTable(tableModel);
							table.setModel(tableModel);

						} catch (Exception ex) {
							System.err.println(ex.getMessage());
						}
						
					}
					}
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}

}
	
		
}
