package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StaffLogic {

	private static StaffLogic instance = null;

	public static StaffLogic getInstance() {
		if (instance == null) {
			instance = new StaffLogic();
		}
		return instance;
	}

	private ArrayList<Staff> staffs = new ArrayList<Staff>();
	private ArrayList<String> columns;
	
	
	private StaffLogic() {
		
		columns = new ArrayList<String>();
		columns.add("IME");
		columns.add("PREZIME");
		columns.add("JMBG");
		columns.add("DATUM RODJENJA");
		columns.add("EMAIL");
		columns.add("ADRESA");

		initStaff();
		
	}
	
	public void initStaff() {
		
		Address address1 = new Address(1, "Dunavska", "Novi Sad");
		Address address2 = new Address(1, "Fruskogorska", "Novi Sad");
		Staff staff1 = new Staff("Marko", "Markovic", "123123", LocalDateTime.now(), "email@yahoo.com", address1);
		Staff staff2 = new Staff("Pera", "Peric", "5211232", LocalDateTime.now(), "lala@gmail.com", address2);
		staffs.add(staff1);
		staffs.add(staff2);
	}
	

	public void deleteStaffMember(String jmbg){
		for(Staff staff : this.staffs) {
			if(staff.getJmbg().equals(jmbg)) {
				staffs.remove(staff);
				break;
			}
		}
	}


	public ArrayList<Staff> getStaffs() {
		return staffs;
	}
	
	public void setStaff(ArrayList<Staff> staffs) {
		this.staffs = staffs;
	}
	

	//########FUNCKIJE ZA TABELU########
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Staff getRow(int rowIndex) {
		return this.staffs.get(rowIndex);
	}
	
	
	public Object getValueAt(int row, int column) {
		Staff staff = staffs.get(row);
		switch (column) {
		case 0:
			return staff.getName();
		case 1:
			return staff.getSurname();
		case 2:
			return staff.getJmbg();
		case 3:
			return staff.getDateOfBirth().toString();
		case 4:
			return staff.getEmail();
		case 5:
			return staff.getAddress().getCity() + " " + staff.getAddress().getStreet() + " " + staff.getAddress().getNumber();
		default:
			return null;
		}
	}
	//################################
	
	
}
