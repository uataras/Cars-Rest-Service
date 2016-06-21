package tel_ran.cars.web.common;

import java.util.Date;

public class OwnerData {
	int id;
	String name;
	Date birthDate;
	
	public OwnerData(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public OwnerData() {
		super();
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
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "OwnerData [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
