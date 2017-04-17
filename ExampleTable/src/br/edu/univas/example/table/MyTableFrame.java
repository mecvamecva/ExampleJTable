package br.edu.univas.example.table;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class MyTableFrame extends JFrame {

	private static final long serialVersionUID = -9179603935518411085L;

	private JTextField firstField;
	private JFormattedTextField dateFormattedField;
	private JButton okButton;
	private JTable dataTable;
	private DefaultTableModel dataTableModel;
	private JScrollPane dataScrollPane;

	private GridBagConstraints firstFieldConstraints;
	private GridBagConstraints dateFormattedFieldConstraints;
	private GridBagConstraints okButtonConstraints;
	private GridBagConstraints dataScrollPaneConstraints;

	public MyTableFrame() {
		super("Example table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void initialize() {
		setLayout(new GridBagLayout());

		add(getFirstField(), getFirstFieldConstraints());
		add(getDateFormattedField(), getDateFormattedFieldConstraints());
		add(getOkButton(), getOkButtonConstraints());
		add(getDataScrollPane(), getDataScrollPaneConstraints());
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

	private JFormattedTextField getDateFormattedField() {
		if (dateFormattedField == null) {
			SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
			dateFormattedField = new JFormattedTextField(df);
			Dimension prefSize = dateFormattedField.getPreferredSize();
			prefSize.width = 60;
			dateFormattedField.setPreferredSize(prefSize);
			installFormatter();
		}
		return dateFormattedField;
	}

	private void installFormatter() {
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			mf.install(dateFormattedField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

	private GridBagConstraints getFirstFieldConstraints() {
		if (firstFieldConstraints == null) {
			firstFieldConstraints = new GridBagConstraints();
			firstFieldConstraints.gridx = 0;
			firstFieldConstraints.gridy = 1;
		}
		return firstFieldConstraints;
	}

	private GridBagConstraints getDateFormattedFieldConstraints() {
		if (dateFormattedFieldConstraints == null) {
			dateFormattedFieldConstraints = new GridBagConstraints();
			dateFormattedFieldConstraints.gridx = 1;
			dateFormattedFieldConstraints.gridy = 1;
		}
		return dateFormattedFieldConstraints;
	}

	private GridBagConstraints getOkButtonConstraints() {
		if (okButtonConstraints == null) {
			okButtonConstraints = new GridBagConstraints();
			okButtonConstraints.gridx = 2;
			okButtonConstraints.gridy = 1;
		}
		return okButtonConstraints;
	}

	private GridBagConstraints getDataScrollPaneConstraints() {
		if (dataScrollPaneConstraints == null) {
			dataScrollPaneConstraints = new GridBagConstraints();
			dataScrollPaneConstraints.gridx = 0;
			dataScrollPaneConstraints.gridy = 0;
			dataScrollPaneConstraints.gridwidth = 3;
		}
		return dataScrollPaneConstraints;
	}

	private void okClicked() {
		String text1 = getFirstField().getText();
		String text2 = getDateFormattedField().getText();
		String[] row = new String[] { text1, text2 };
		getDataTableModel().addRow(row);
	}

	public static void main(String[] args) {
		new MyTableFrame().setVisible(true);
	}

}
