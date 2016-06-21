package tel_ran.cars.web.common;

public class CarData {
	long regNumber;
	String color;
	
	public CarData(long regNumber, String color) {
		super();
		this.regNumber = regNumber;
		this.color = color;
	}

	public CarData() {
		super();
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
	
	@Override
	public String toString() {
		return "CarData [regNumber=" + regNumber + ", color=" + color + "]";
	}
	
}
