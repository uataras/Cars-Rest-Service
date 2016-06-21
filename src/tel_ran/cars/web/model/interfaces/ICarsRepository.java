package tel_ran.cars.web.model.interfaces;

import tel_ran.cars.web.common.CarData;
import tel_ran.cars.web.common.ModelData;
import tel_ran.cars.web.common.OwnerData;

public interface ICarsRepository {
	Iterable<CarData> getCarsOwner(OwnerData owner);
	/*
		getting most popular car models according to owner ages
	*/
	Iterable<ModelData> getMostPopularCarModel(int minBirthYear, int maxBirthYear);
	/*
		getting data about the specific car's owners
	*/
	Iterable<OwnerData> getOwnersCar(CarData car);
}
