package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class SoftwareJTable extends JTable {
	
	private static final long serialVersionUID = 8357328090930592482L;
	
	private static SoftwareJTable instance = null;
	public static SoftwareJTable getInstance() {
		if (instance == null) {
			instance = new SoftwareJTable();
		}
		return instance;
	}
	
	public SoftwareJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableSoftware());
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Integer.class, centerRenderer);
        setDefaultRenderer(Double.class, centerRenderer);
        
        Action viewBrushes = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        BrushesDialog brushesDialog = new BrushesDialog(modelRow);
		        brushesDialog.setVisible(true);
			}
		};
		ButtonColumn buttonColumn = new ButtonColumn(this, viewBrushes, 1);

	}
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return true;
	}
}
