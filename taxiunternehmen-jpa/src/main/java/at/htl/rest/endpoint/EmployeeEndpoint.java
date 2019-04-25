package at.htl.rest.endpoint;

import at.htl.persistence.dao.Dao;
import at.htl.persistence.dao.EmployeeDao;
import at.htl.persistence.entity.Employee;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("employee")
public class EmployeeEndpoint extends AbstractCrudEndpoint<Employee> {
    @Inject
    EmployeeDao employeeDao;

    @Override
    protected Dao<Employee> getDao() {
        return employeeDao;
    }
}
