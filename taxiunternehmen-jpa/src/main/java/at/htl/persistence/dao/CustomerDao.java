package at.htl.persistence.dao;

import at.htl.persistence.entity.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerDao extends Dao<Customer> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
