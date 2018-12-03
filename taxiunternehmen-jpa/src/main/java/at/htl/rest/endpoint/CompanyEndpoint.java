package at.htl.rest.endpoint;

import at.htl.persistence.dao.BossDao;
import at.htl.persistence.dao.CompanyDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Company;
import at.htl.rest.dto.BossDto;
import at.htl.rest.dto.CompanyDto;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("company")
public class CompanyEndpoint extends EntityEndpoint<Company, CompanyDto>{

    @Inject
    CompanyDao companyDao;
    @Inject
    BossDao bossDao;

    @Override
    protected Dao<Company> getEntityDao() {
        return companyDao;
    }

    @Override
    protected Class<Company> getEntityClass() {
        return Company.class;
    }

    @Override
    protected CompanyDto getDtoFromEntity(Company company) {
        return company.toDto();
    }

    @Override
    protected Company updateEntityWithDto(Company company, CompanyDto companyDto) {
        company.update(companyDto, bossDao);
        return company;
    }
}
