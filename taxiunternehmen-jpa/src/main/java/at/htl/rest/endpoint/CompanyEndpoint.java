package at.htl.rest.endpoint;

import at.htl.persistence.dao.BossDao;
import at.htl.persistence.dao.CompanyDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Company;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("company")
public class CompanyEndpoint extends AbstractCrudEndpoint<Company>{

    @Inject
    CompanyDao companyDao;

    @Override
    protected Dao<Company> getDao() {
        return companyDao;
    }
}
