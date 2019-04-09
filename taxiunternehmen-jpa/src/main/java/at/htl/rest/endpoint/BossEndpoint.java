package at.htl.rest.endpoint;

import at.htl.persistence.dao.BossDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Boss;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("boss")
public class BossEndpoint extends AbstractCrudEndpoint<Boss> {

    @Inject
    BossDao bossDao;

    @Override
    protected Dao<Boss> getDao() {
        return bossDao;
    }
}
