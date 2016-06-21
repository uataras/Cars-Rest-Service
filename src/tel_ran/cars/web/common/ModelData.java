package tel_ran.cars.web.common;

public class ModelData {
	int code;
	String name;
	int year;
	int volume;
	int occurrences;
	
	public ModelData(String name, int year, int volume) {
		super();
		this.name = name;
		this.year = year;
		this.volume = volume;
	}

	public ModelData() {
		super();
	}
	
	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "ModelData [code=" + code + ", name=" + name + ", year=" + year + ", volume=" + volume + "]";
	}
	
}
