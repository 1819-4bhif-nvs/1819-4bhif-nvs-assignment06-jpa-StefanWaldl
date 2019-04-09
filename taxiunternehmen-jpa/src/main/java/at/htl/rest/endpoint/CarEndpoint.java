package at.htl.rest.endpoint;

import at.htl.persistence.dao.CarDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Car;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("car")
public class CarEndpoint extends AbstractCrudEndpoint<Car> {

    @Inject
    CarDao cardao;

    @Override
    protected Dao<Car> getDao() {
        return cardao;
    }
}
