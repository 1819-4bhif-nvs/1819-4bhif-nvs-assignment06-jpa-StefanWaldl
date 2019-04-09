package at.htl.persistence.dao;

import at.htl.persistence.entity.Bill;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BillDao extends Dao<Bill> {

    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Bill> getEntityClass() {
        return Bill.class;
    }
}
