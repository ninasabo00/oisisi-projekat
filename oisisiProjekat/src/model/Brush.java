package model;

public class Brush {

    private String name;
    private String purpose;
    private String color;
    
    public Brush() {}
    
	public Brush(String name, String purpose, String color) {
		super();
		this.name = name;
		this.purpose = purpose;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
    
    
}
