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
	private ArrayList<Render> renders = new ArrayList<Render>();
	private ArrayList<Brush> brushes = new ArrayList<Brush>();

	private SoftwareLogic() {
		
		columns = new ArrayList<String>();
		columns.add("NAZIV");
		columns.add("CETKICE");
		columns.add("FAJL FORMAT");
		columns.add("ALATI ZA ANIMACIJU");
		columns.add("RENDER");
		initRenders();
		initBrushes();
		initSoftwares();
	}
	
	public void initRenders() {
		Render render1 = new Render(
				"Materijal 1, Materijal 11",
				"Kamera 1, Kamera 11",
				"Objekat 1, Objekat 11",
				"Render 1"
				);
		Render render2 = new Render(
				"Materijal 2, Materijal 22",
				"Kamera 22, Kamera 22",
				"Objekat 22, Objekat 22",
				"Render 2"
				);
		Render render3 = new Render(
				"Materijal 3, Materijal 33",
				"Kamera 3, Kamera 33",
				"Objekat 3, Objekat 33",
				"Render 3"
				);
		Render render4 = new Render(
				"Materijal 4, Materijal 44",
				"Kamera 4, Kamera 44",
				"Objekat 4, Objekat 44",
				"Render 4"
				);
		renders.add(render1);
		renders.add(render2);
		renders.add(render3);
		renders.add(render4);
	}
	
	private void initBrushes() {
		Brush brush1 = new Brush("BrushName1", "Brush description", "#FF0700");
		Brush brush2 = new Brush("BrushName2", "Brush description", "#0059FF");
		Brush brush3 = new Brush("BrushName3", "Brush description", "#B900FF");
		Brush brush4 = new Brush("BrushName4", "Brush description", "#F0FF00");
		brushes.add(brush1);
		brushes.add(brush2);
		brushes.add(brush3);
		brushes.add(brush4);
	}
	
	public void initSoftwares() {
		ArrayList<Brush> software1brushes = new ArrayList<Brush>();
		software1brushes.add(brushes.get(0));
		software1brushes.add(brushes.get(1));
		
		ArrayList<Brush> software2brushes = new ArrayList<Brush>();
		software2brushes.add(brushes.get(2));
		software2brushes.add(brushes.get(3));
		
		ArrayList<Brush> software3brushes = new ArrayList<Brush>();
		software3brushes.add(brushes.get(1));
		software3brushes.add(brushes.get(3));
		
		Software software1 = new Software("Software 1", software1brushes, ".format1", "alat1, alat2", renders.get(0));
		Software software2 = new Software("Software 2", software2brushes, ".format3", "alat31, alat4", renders.get(2));
		Software software3 = new Software("Software 3", software3brushes, ".format1", "alat22, alat14", renders.get(3));

		softwares.add(software1);
		softwares.add(software2);
		softwares.add(software3);
	}
	
	public ArrayList<Render> getRenders(){
		return renders;
	}
	
	public ArrayList<Brush> getBrushes(){
		return brushes;
	}
	
	public ArrayList<Software> getSoftwares() {
		return softwares;
	}
	
	public void setSoftware(ArrayList<Software> softwares) {
		this.softwares = softwares;
	}
	
	public void addSoftware(Software software) {
		this.softwares.add(software);
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
	
	public void editSoftware(Software software, String softwareName) {
		for(Software s : this.softwares) {
			if(s.getName().equals(softwareName)) {
				s.setName(software.getName());
				s.setFileFormat(software.getFileFormat());
				s.setBrushes(software.getBrushes());
				s.setRender(software.getRender());
				s.setAnimationTools(software.getAnimationTools());
				break;
			}
		}
	}
	
	public void deleteSoftware(String softwareName) {
		for(Software s : this.softwares) {
			if(s.getName().equals(softwareName)) {
				this.softwares.remove(s);
				break;
			}
		}
	}
	
	public boolean softwareExist(String softwareName) {
		for(Software s : this.softwares) {
			if(s.getName().equals(softwareName)) {
				return true;
			}
		}
		return false;
	}
}
