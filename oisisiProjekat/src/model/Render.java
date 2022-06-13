package model;

import java.util.List;

public class Render {

    private List<String> materials;
    private List<String> cameras;
    private List<String> objects;
    private String name;
    
    
    public Render() {}
    
	public Render(List<String> materials, List<String> cameras, List<String> objects, String name) {
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


	public List<String> getMaterials() {
		return materials;
	}


	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}


	public List<String> getCameras() {
		return cameras;
	}


	public void setCameras(List<String> cameras) {
		this.cameras = cameras;
	}


	public List<String> getObjects() {
		return objects;
	}


	public void setObjects(List<String> objects) {
		this.objects = objects;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
    
    
    
    
    
}
