package at.htl.persistence.dao;

import at.htl.persistence.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonDao extends Dao<Person> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
