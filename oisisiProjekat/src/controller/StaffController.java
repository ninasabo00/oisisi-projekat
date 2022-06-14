package controller;

import model.Staff;
import model.StaffLogic;
import view.TabbedPane;

public class StaffController {

	private static StaffController instance = null;
	
	public static StaffController getInstance() {
		if (instance == null) {
			instance = new StaffController();
		}
		return instance;
	}	
	
	public void deleteStaffMember(String jmbg) {
		StaffLogic.getInstance().deleteStaffMember(jmbg);
		TabbedPane.getInstance().updateStaffTable();
	}
	
	public void addStaff(Staff staff) {
		StaffLogic.getInstance().addStaff(staff);
		TabbedPane.getInstance().updateStaffTable();
	}
}
