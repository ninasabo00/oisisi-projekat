package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaffLogic {

	private static StaffLogic instance = null;

	public static StaffLogic getInstance() {
		if (instance == null) {
			instance = new StaffLogic();
		}
		return instance;
	}

	private ArrayList<Staff> staffs = new ArrayList<Staff>();
	private ArrayList<Staff> staffs2 = new ArrayList<Staff>();	//koristi se za pretragu
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
		List<Software> softwares = new ArrayList<Software>();
		
		Staff staff1 = new Staff("Marko", "Markovic", "123123", LocalDate.now(), "email@yahoo.com", address1);
		staff1.setSoftwares(softwares);
		Staff staff2 = new Staff("Pera", "Peric", "5211232", LocalDate.now(), "lala@gmail.com", address2);
		staff2.setSoftwares(softwares);
		Staff staff3 = new Staff("Nebojsa", "Mrkonjic", "1222223", LocalDate.now(), "mrkonja@yahoo.com", address1);
		staff3.setSoftwares(softwares);
		Staff staff4 = new Staff("Sejo", "Kalac", "211111", LocalDate.now(), "kalac@gmail.com", address2);
		staff4.setSoftwares(softwares);
		
		staffs.add(staff1);
		staffs.add(staff2);
		staffs.add(staff3);
		staffs.add(staff4);
		staffs2.add(staff1);
		staffs2.add(staff2);
		staffs2.add(staff3);
		staffs2.add(staff4);
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
	
	public void addStaff(Staff staff) {
		this.staffs.add(staff);
	}

	public Staff findStaff(String jmbg){
		for(Staff staff : this.staffs) {
			if(staff.getJmbg().equals(jmbg)) {
				return staff;
			}
		}
		return null;
	}

	public void editStaff(Staff staff, String jmbg){ // da nismo slali jmbg onda nikad ne bi pronasao starog usera jer se promenio jmbg i nikad ga ne bi izmenio
		for(Staff s : this.staffs) {
			if(s.getJmbg().equals(jmbg)) {
				s.setName(staff.getName());
				s.setSurname(staff.getSurname());
				s.setJmbg(staff.getJmbg());
				s.setDateOfBirth(staff.getDateOfBirth());
				s.setEmail(staff.getEmail());
				s.setAddress(staff.getAddress());
				s.setSoftwares(staff.getSoftwares());
				break;
			}

		}
	}

	public void searchStaff(String name){
		ArrayList<Staff> temp = new ArrayList<Staff>();
		if(name != "" && name != null){
			for(Staff staff : this.staffs2) {
				if(staff.getName().toLowerCase().contains(name.toLowerCase()) || staff.getSurname().toLowerCase().contains(name.toLowerCase())) {
					temp.add(staff);
				}
			}
			this.staffs = temp;
		}else{
			this.staffs = this.staffs2;
		}
	}
	
}
