package at.htl.rest.endpoint;

import at.htl.persistence.dao.BossDao;
import at.htl.persistence.dao.Dao;
import at.htl.persistence.entity.Boss;
import at.htl.rest.dto.BossDto;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("boss")
public class BossEndpoint extends EntityEndpoint<Boss, BossDto> {

    @Inject
    BossDao bossDao;

    @Override
    protected Dao<Boss> getEntityDao() {
        return bossDao;
    }

    @Override
    protected Class<Boss> getEntityClass() {
        return Boss.class;
    }

    @Override
    protected BossDto getDtoFromEntity(Boss boss) {
        return boss.toDto();
    }


    @Override
    protected Boss updateEntityWithDto(Boss boss, BossDto bossDto) {
        boss.update(bossDto);
        return boss;
    }
}
