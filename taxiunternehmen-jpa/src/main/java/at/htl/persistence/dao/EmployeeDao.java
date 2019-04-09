package at.htl.persistence.dao;

import at.htl.persistence.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDao extends Dao<Employee> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
