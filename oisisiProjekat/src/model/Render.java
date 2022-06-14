package model;

import java.util.List;

public class Render {

    private String materials;
    private String cameras;
    private String objects;
    private String name;
    
    
    public Render() {}
    
	public Render(String materials, String cameras, String objects, String name) {
		super();
		this.materials = materials;
		this.cameras = cameras;
		this.objects = objects;
		this.name = name;
	}


	public Render(String name) {
		super();
		this.name = name;
	}


	public String getMaterials() {
		return materials;
	}


	public void setMaterials(String materials) {
		this.materials = materials;
	}


	public String getCameras() {
		return cameras;
	}


	public void setCameras(String cameras) {
		this.cameras = cameras;
	}


	public String getObjects() {
		return objects;
	}


	public void setObjects(String objects) {
		this.objects = objects;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
    
    
    
    
    
}
