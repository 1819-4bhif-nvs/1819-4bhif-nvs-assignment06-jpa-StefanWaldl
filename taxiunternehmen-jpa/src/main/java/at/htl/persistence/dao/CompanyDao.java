package at.htl.persistence.dao;

import at.htl.persistence.entity.Company;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CompanyDao extends Dao<Company> {

    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Company> getEntityClass() {
        return Company.class;
    }
}
