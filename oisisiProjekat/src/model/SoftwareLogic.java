package model;

import java.util.ArrayList;

public class SoftwareLogic {
	private static SoftwareLogic instance = null;

	public static SoftwareLogic getInstance() {
		if (instance == null) {
			instance = new SoftwareLogic();
		}
		return instance;
	}
	
	private ArrayList<Software> softwares = new ArrayList<Software>();
	private ArrayList<String> columns;
	
	private SoftwareLogic() {
		
		columns = new ArrayList<String>();
		columns.add("NAZIV");
		columns.add("CETKICE");
		columns.add("FAJL FORMAT");
		columns.add("ALATI ZA ANIMACIJU");
		columns.add("RENDER");

		initSoftwares();
	}
	
	public void initSoftwares() {
		Brush brush1 = new Brush("BrushName1", "Brush description", "red");
		Brush brush2 = new Brush("BrushName2", "Brush description", "blue");
		ArrayList<Brush> brushes = new ArrayList<Brush>();
		brushes.add(brush1);
		brushes.add(brush2);
		
		Render render1 = new Render();
		Software software1 = new Software("Software 1", brushes, ".fromat", "alat1, alat2", render1);
		Software software2 = new Software("Software 2", brushes, ".fromat", "alat31, alat4", render1);
		
		softwares.add(software1);
		softwares.add(software2);
	}
	
	public ArrayList<Software> getSoftwares() {
		return softwares;
	}
	
	public void setSoftware(ArrayList<Software> softwares) {
		this.softwares = softwares;
	}
	
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Software getRow(int rowIndex) {
		return this.softwares.get(rowIndex);
	}
	
	
	public Object getValueAt(int row, int column) {
		Software software = softwares.get(row);
		switch (column) {
		case 0:
			return software.getName();
		case 1:
			return "Brushes ("+software.getBrushes().size()+")";
		case 2:
			return software.getFileFormat();
		case 3:
			return software.getAnimationTools();
		case 4:
//			return software.getRender();
			return "render";
		default:
			return null;
		}
	}
	//################################
	
	public Software findSoftware(String softwareName) {
		for(Software software : this.softwares) {
			if(software.getName().equals(softwareName)) {
				return software;
			}
		}
		return null;
	}
}
