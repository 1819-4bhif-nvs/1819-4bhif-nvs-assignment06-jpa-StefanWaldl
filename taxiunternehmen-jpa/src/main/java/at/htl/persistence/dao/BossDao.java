package at.htl.persistence.dao;

import at.htl.persistence.entity.Boss;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BossDao extends Dao<Boss> {

    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Boss> getEntityClass() {
        return Boss.class;
    }
}
