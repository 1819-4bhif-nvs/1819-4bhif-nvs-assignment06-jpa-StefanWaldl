package at.htl.rest.endpoint;

import at.htl.persistence.dao.CustomerDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("customer")
public class CustomerEndpoint extends AbstractCrudEndpoint<Customer> {
    @Inject
    CustomerDao customerDao;
    @Override
    protected Dao<Customer> getDao() {
        return customerDao;
    }
}
