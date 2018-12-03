package at.htl.rest.endpoint;

import at.htl.persistence.dao.CarDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Car;
import at.htl.rest.dto.CarDto;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("car")
public class CarEndpoint extends EntityEndpoint<Car, CarDto> {

    @Inject
    CarDao cardao;

    @Override
    protected Dao<Car> getEntityDao() {
        return cardao;
    }

    @Override
    protected Class<Car> getEntityClass() {
        return Car.class;
    }

    @Override
    protected CarDto getDtoFromEntity(Car car) {
        return car.toDto();
    }

    @Override
    protected Car updateEntityWithDto(Car car, CarDto carDto) {
        car.update(carDto);
        return car;
    }
}
