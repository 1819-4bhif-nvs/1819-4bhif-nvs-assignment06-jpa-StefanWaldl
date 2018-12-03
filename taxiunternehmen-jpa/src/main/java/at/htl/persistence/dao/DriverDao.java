package at.htl.persistence.dao;

import at.htl.persistence.entity.Driver;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DriverDao extends Dao<Driver> {

    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Driver> getEntityClass() {
        return Driver.class;
    }
}
