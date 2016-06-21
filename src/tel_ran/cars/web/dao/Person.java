package tel_ran.cars.web.dao;

import java.util.*;

import javax.persistence.*;

@Entity
public class Person {
	@Id
	int id;
	String name;
	@Temporal(TemporalType.DATE)
	Date birthday;
	@ManyToMany(mappedBy = "owners")
	Set<Car> car;		
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

	public Person(int id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Set<Car> getCar() {
		return car;
	}

}
