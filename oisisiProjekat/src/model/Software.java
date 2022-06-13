package model;

import java.util.List;

public class Software {

    private String name;
    private List<Brush> brushes;
    private String fileFormat;
    private List<String> animationTools;
    private Render render;
    
    public Software() {}
    
	public Software(String name, List<Brush> brushes, String fileFormat, List<String> animationTools, Render render) {
		super();
		this.name = name;
		this.brushes = brushes;
		this.fileFormat = fileFormat;
		this.animationTools = animationTools;
		this.render = render;
	}


	//without lists
	public Software(String name, String fileFormat, Render render) {
		super();
		this.name = name;
		this.fileFormat = fileFormat;
		this.render = render;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Brush> getBrushes() {
		return brushes;
	}


	public void setBrushes(List<Brush> brushes) {
		this.brushes = brushes;
	}


	public String getFileFormat() {
		return fileFormat;
	}


	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}


	public List<String> getAnimationTools() {
		return animationTools;
	}


	public void setAnimationTools(List<String> animationTools) {
		this.animationTools = animationTools;
	}


	public Render getRender() {
		return render;
	}


	public void setRender(Render render) {
		this.render = render;
	}
	
	
    
    
}
