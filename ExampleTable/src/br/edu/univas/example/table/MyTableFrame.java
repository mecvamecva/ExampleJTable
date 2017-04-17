package br.edu.univas.example.table;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyTableFrame extends JFrame {

	private static final long serialVersionUID = -9179603935518411085L;

	private JTextField firstField;
	private JTextField secondField;
	private JButton okButton;
	private JTable dataTable;
	private DefaultTableModel dataTableModel;
	private JScrollPane dataScrollPane;

	public MyTableFrame() {
		super("Example table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void initialize() {
		setLayout(new FlowLayout());

		add(getFirstField());
		add(getSecondField());
		add(getOkButton());
		add(getDataScrollPane());
	}

	private JTextField getFirstField() {
		if (firstField == null) {
			firstField = new JTextField();
			Dimension prefSize = firstField.getPreferredSize();
			prefSize.width = 60;
			firstField.setPreferredSize(prefSize);
		}
		return firstField;
	}

	private JTextField getSecondField() {
		if (secondField == null) {
			secondField = new JTextField();
			Dimension prefSize = secondField.getPreferredSize();
			prefSize.width = 60;
			secondField.setPreferredSize(prefSize);
		}
		return secondField;
	}

	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("OK");
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					okClicked();
				}
			});
		}
		return okButton;
	}

	private JTable getDataTable() {
		if (dataTable == null) {
			dataTable = new JTable();
			dataTable.setModel(getDataTableModel());
		}
		return dataTable;
	}

	private DefaultTableModel getDataTableModel() {
		if (dataTableModel == null) {
			dataTableModel = new DefaultTableModel();
			String[] identifiers = new String[] { "Texto 1", "Texto 2" };
			dataTableModel.setColumnIdentifiers(identifiers);
		}
		return dataTableModel;
	}

	private JScrollPane getDataScrollPane() {
		if (dataScrollPane == null) {
			dataScrollPane = new JScrollPane();
			dataScrollPane.setViewportView(getDataTable());
			dataScrollPane.setPreferredSize(new Dimension(300, 300));
		}
		return dataScrollPane;
	}

	private void okClicked() {
		String text1 = getFirstField().getText();
		String text2 = getSecondField().getText();
		String[] row = new String[] { text1, text2 };
		getDataTableModel().addRow(row);
	}

	public static void main(String[] args) {
		new MyTableFrame().setVisible(true);
	}

}
