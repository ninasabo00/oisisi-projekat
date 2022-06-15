package model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Render> renders = new ArrayList<Render>();
	
	private SoftwareLogic() {
		
		columns = new ArrayList<String>();
		columns.add("NAZIV");
		columns.add("CETKICE");
		columns.add("FAJL FORMAT");
		columns.add("ALATI ZA ANIMACIJU");
		columns.add("RENDER");
		initRenders();
		initSoftwares();
	}
	
	public void initRenders() {
		Render render1 = new Render(
				"Materijal 1, Materijal 2",
				"Kamera 1, Kamera 2",
				"Objekat 1, Objekat 2",
				"Render 1"
				);
		Render render2 = new Render(
				"Materijal 1, Materijal 2",
				"Kamera 1, Kamera 2",
				"Objekat 1, Objekat 2",
				"Render 2"
				);
		Render render3 = new Render(
				"Materijal 1, Materijal 2",
				"Kamera 1, Kamera 2",
				"Objekat 1, Objekat 2",
				"Render 3"
				);
		Render render4 = new Render(
				"Materijal 1, Materijal 2",
				"Kamera 1, Kamera 2",
				"Objekat 1, Objekat 2",
				"Render 4"
				);
		renders.add(render1);
		renders.add(render2);
		renders.add(render3);
		renders.add(render4);
	}
	
	public void initSoftwares() {
		Brush brush1 = new Brush("BrushName1", "Brush description", "red");
		Brush brush2 = new Brush("BrushName2", "Brush description", "blue");
		ArrayList<Brush> brushes = new ArrayList<Brush>();
		brushes.add(brush1);
		brushes.add(brush2);
		
		
		Software software1 = new Software("Software 1", brushes, ".fromat", "alat1, alat2", renders.get(0));
		Software software2 = new Software("Software 2", brushes, ".fromat", "alat31, alat4", renders.get(2));
		
		softwares.add(software1);
		softwares.add(software2);
	}
	
	public List<Render> getRenders(){
		return renders;
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
			return software.getRender().getName();
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
