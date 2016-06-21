package tel_ran.cars.web.model.impl;

import java.util.*;
import javax.persistence.*;
import tel_ran.cars.web.common.CarData;
import tel_ran.cars.web.common.ModelData;
import tel_ran.cars.web.common.OwnerData;
import tel_ran.cars.web.dao.Car;
import tel_ran.cars.web.dao.Model;
import tel_ran.cars.web.dao.Person;
import tel_ran.cars.web.model.interfaces.ICarsRepository;

public class CarsRepositoryOrmImpl implements ICarsRepository {
	@PersistenceContext(unitName="springHibernate", type=PersistenceContextType.EXTENDED)
	EntityManager em;
	
	@Override
	public Iterable<CarData> getCarsOwner(OwnerData owner) {
		Query query = em.createQuery("select o.cars from Person o where o.id=?1");
		query.setParameter(1, owner.getId());
		List<Car> cars = query.getResultList();
		return toListCarData(cars);
	}

	private Iterable<CarData> toListCarData(List<Car> cars) {
		List<CarData> res = new ArrayList<>();
		for(Car car : cars)
			res.add(new CarData(car.getRegNumber(),car.getColor()));
		return res;
	}

	@Override
	public Iterable<ModelData> getMostPopularCarModel(int minBirthYear, int maxBirthYear) {
		Query query = em.createQuery("select m,count(m.code) from Model m join m.cars c"
				 + " join c.owners o where year(o.birthDay) between ?1 and ?2"
				 + " group by(m.code) order by(count(m.code)");
		query.setParameter(1, minBirthYear).setParameter(2, maxBirthYear);
		List<Object[]> res = query.getResultList();
		return toListModelData(res);
	}

	private Iterable<ModelData> toListModelData(List<Object[]> modelData) {
		List<ModelData> result = new ArrayList<>();
		for(Object[] objects : modelData){
			result.add(getModelDataFromObject(objects));
		}
		return result;
	}

	private ModelData getModelDataFromObject(Object[] objects) {
		Model model = (Model)objects[0];
		ModelData mData = new ModelData(model.getName(),model.getYear(),model.getVolue());
		Integer occurrences = (Integer) objects[1];
		mData.setOccurrences(occurrences);
		return mData;
	}

	@Override
	public Iterable<OwnerData> getOwnersCar(CarData car) {
		Query query = em.createQuery("select c.owners from Car c where regNumber=?1");
		query.setParameter(1, car.getRegNumber());
		List<Person> owners = query.getResultList();
		return toListOwnerData(owners);
	}

	private Iterable<OwnerData> toListOwnerData(List<Person> owners) {
		List<OwnerData> res = new ArrayList<>();
		for(Person person : owners)
			res.add(new OwnerData(person.getId(),person.getName(),person.getBirthday()));
		return res;
	}

}
