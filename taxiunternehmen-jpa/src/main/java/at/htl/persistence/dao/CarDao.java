package at.htl.persistence.dao;

import at.htl.persistence.entity.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarDao extends Dao<Car> {

    @PersistenceContext(name = "primaryPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Car> getEntityClass() {
        return Car.class;
    }
}
