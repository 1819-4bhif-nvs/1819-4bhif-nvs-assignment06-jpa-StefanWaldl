package at.htl.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public abstract class Dao<TEntity> {
    protected abstract EntityManager getEntityManager();
    protected abstract Class<TEntity> getEntityClass();

    public void create(TEntity lesson) {
        getEntityManager().persist(lesson);
        getEntityManager().flush();
    }

    public List<TEntity> findAll(){
        return getEntityManager()
                .createNamedQuery(getEntityClass().getSimpleName() + ".getAll", getEntityClass())
                .getResultList();
    }
    public TEntity findById(Long id){
        try {
            return getEntityManager()
                    .createNamedQuery(getEntityClass().getSimpleName() + ".getById", getEntityClass())
                    .setParameter("id", id)
                    .getSingleResult();
        } catch(NoResultException ex){
            return null;
        }
    }

    public boolean update(TEntity lesson) {
        try{
            getEntityManager().merge(lesson);
            getEntityManager().flush();
        } catch(IllegalArgumentException ex){
            return false;
        }
        return true;
    }

    public boolean delete(Long id) {
        try{
            getEntityManager().remove(findById(id));
            getEntityManager().flush();
        } catch(IllegalArgumentException ex){
            return false;
        }
        return true;
    }
}
