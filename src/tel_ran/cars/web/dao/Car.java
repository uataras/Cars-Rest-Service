package tel_ran.cars.web.dao;

import java.util.*;

import javax.persistence.*;

@Entity
public class Car {
	@Id		
	long regNumber;
	String color;
	@ManyToMany		
	Set<Person> owners;   
	@ManyToOne	
	Model model;	

	public Car(long regNumber, String color) {
		super();
		this.regNumber = regNumber;
		this.color = color;
	}

	public Car() {
	}

	public long getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(long regNumber) { 
		this.regNumber = regNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Person> getOwners() {
		return owners;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", color=" + color + ", toString()=" + super.toString() + "]";
	}

}
