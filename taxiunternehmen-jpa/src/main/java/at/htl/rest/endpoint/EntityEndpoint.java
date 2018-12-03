package at.htl.rest.endpoint;

import at.htl.persistence.dao.Dao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
public abstract class EntityEndpoint<TEntity, TEntityDto> {
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<TEntityDto> getAllLessons(){
        return getEntityDao()
                .getAll()
                .stream()
                .map(entity -> getDtoFromEntity(entity))
                .collect(Collectors.toList());
    }

    protected abstract Dao<TEntity> getEntityDao();
    protected abstract Class<TEntity> getEntityClass();
    protected abstract TEntityDto getDtoFromEntity(TEntity entity);
    protected abstract TEntity updateEntityWithDto(TEntity entity, TEntityDto dto);

    @GET
    @Path("/{id}")
    public Response getLessonById(@PathParam("id") Long id){
        TEntity entity = getEntityDao().getById(id);
        if(entity == null)
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        else
            return Response
                    .ok()
                    .entity(getDtoFromEntity(entity))
                    .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLesson(TEntityDto dto){
        if(dto == null)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();

        TEntity entity = null;
        try {
            entity = getEntityClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        entity = updateEntityWithDto(entity, dto);

        getEntityDao().create(entity);

        return Response
                .status(Response.Status.CREATED)
                .entity(getDtoFromEntity(entity))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateLesson(TEntityDto dto, @PathParam("id") Long id){
        TEntity entity = getEntityDao().getById(id);
        if(entity == null){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        entity = updateEntityWithDto(entity, dto);
        if(!getEntityDao().update(entity)){
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .build();
        }
        return Response
                .ok()
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLesson(@PathParam("id") Long id){
        if(!getEntityDao().delete(id)){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .ok()
                .build();
    }
}
