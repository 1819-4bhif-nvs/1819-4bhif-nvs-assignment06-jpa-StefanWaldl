package at.htl.rest.endpoint;


import at.htl.persistence.dao.Dao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
abstract class AbstractCrudEndpoint<TEntity> {
    protected abstract Dao<TEntity> getDao();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TEntity entity){
        Dao dao = getDao();
        dao.create(entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(entity)
                .build();
    }

    @GET
    public List<TEntity> read(){
        return getDao()
                .findAll();
    }

    @GET
    @Path("{id}")
    public TEntity readById(@PathParam("id") Long id){
        return getDao().findById(id);
    }

    @PATCH
    @Path("{id}")
    public Response update(@PathParam("id") Long id, TEntity entity){
        getDao().update(entity);

        return Response
                .ok()
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        getDao().delete(id);
        return Response
                .ok()
                .build();
    }
}
