package at.htl.rest.endpoint;

import at.htl.persistence.dao.BillDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Bill;

import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

@Path("bill")
public class BillEndpoint extends AbstractCrudEndpoint<Bill> {

    @Inject
    BillDao billDao;

    @Override
    protected Dao<Bill> getDao() {
        return billDao;
    }
}
