package view;

import javax.swing.table.AbstractTableModel;

import model.StaffLogic;

public class AbstractTableStaff extends AbstractTableModel {

	private static final long serialVersionUID = -9060819298402812975L;

public AbstractTableStaff() {}
	
	@Override
	public int getColumnCount() {
		return StaffLogic.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return StaffLogic.getInstance().getStaffs().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StaffLogic.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return StaffLogic.getInstance().getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(StaffLogic.getInstance().getStaffs().isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}
	
	
}
