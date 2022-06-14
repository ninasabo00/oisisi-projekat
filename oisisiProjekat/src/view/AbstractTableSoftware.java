package view;

import javax.swing.table.AbstractTableModel;

import model.SoftwareLogic;
import model.StaffLogic;

public class AbstractTableSoftware extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return SoftwareLogic.getInstance().getSoftwares().size();
	}
	
	@Override
	public int getColumnCount() {
		return SoftwareLogic.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SoftwareLogic.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return SoftwareLogic.getInstance().getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(SoftwareLogic.getInstance().getSoftwares().isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}
}
