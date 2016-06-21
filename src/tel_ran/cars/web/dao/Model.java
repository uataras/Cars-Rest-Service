package tel_ran.cars.web.dao;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Model {
	@Id
	@GeneratedValue 
	int code;
	String name;
	int year;
	int volume;
	@OneToMany(mappedBy = "model") 
	Set<Car> cars;

	public Model() {

	}

	public Model(String name, int year, int volue) {
		super();
		this.name = name;
		this.year = year;
		this.volume = volue;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public int getVolue() {
		return volume;
	}

	@Override
	public String toString() {
		return "Model [code=" + code + ", name=" + name + ", year=" + year + ", volue=" + volume + "]";
	}

}
