package model;

import java.time.LocalDateTime;
import java.util.List;

public class Staff {

	private String name;
    private String surname;
    private String jmbg;
    private LocalDateTime dateOfBirth;
    private String email;
    private Address address;
    private List<Software> softwares;
    
    
    
    public Staff() {}
    
	public Staff(String name, String surname, String jmbg, LocalDateTime dateOfBirth, String email, Address address,
			List<Software> softwares) {
		super();
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.softwares = softwares;
	}
	
	//without list
	public Staff(String name, String surname, String jmbg, LocalDateTime dateOfBirth, String email, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Software> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}
	
	
	
	
    
    
}
