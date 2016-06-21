package tel_ran.cars.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tel_ran.cars.web.common.CarData;
import tel_ran.cars.web.common.CarsConstants;
import tel_ran.cars.web.common.ModelData;
import tel_ran.cars.web.common.OwnerData;
import tel_ran.cars.web.model.interfaces.ICarsRepository;

@RestController
@RequestMapping("/")
public class CarsServiceController {
	@Autowired
	ICarsRepository cars;
	@RequestMapping(value=CarsConstants.GET_CARS,method=RequestMethod.POST)
	public Iterable<CarData> getCarDataPerOwner(@RequestBody OwnerData owner){
		return cars.getCarsOwner(owner);
	}
	
	@RequestMapping(value=CarsConstants.GET_OWNERS+"/{regNumber}",method=RequestMethod.GET)
	public Iterable<OwnerData> getOwnersData(@PathVariable int regNumber){
		CarData car = new CarData(regNumber, null);
		return cars.getOwnersCar(car);
	}
	
	@RequestMapping(value=CarsConstants.GET_MODELS+"/{minYear}"+"/{maxYear}",method=RequestMethod.GET)
	public Iterable<ModelData> getMostPopularModels(@PathVariable int minYear, @PathVariable int maxYear){
		return cars.getMostPopularCarModel(minYear, maxYear);
	}
}
