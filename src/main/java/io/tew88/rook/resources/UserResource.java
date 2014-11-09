package io.tew88.rook.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import io.tew88.rook.domain.User;
import io.tew88.rook.domain.dao.UserDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {
    
    private final UserDao userDao;
    
    public UserResource(final UserDao userDao) {
        this.userDao = userDao;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> result = userDao.getAll();
        return Response.ok(result, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") final int id) {
        User result = userDao.findById(id);
        if (result != null) {
            return Response.ok(result, MediaType.APPLICATION_JSON).build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) throws URISyntaxException {
        final long result = userDao.persist(user.getName(), user.getEmail(), user.getPasswordHash());
        return Response.created(new URI("/user/" + result)).build();
    }
    
    
    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(User user) {
        userDao.remove(user.getId(), user.getName(), user.getEmail(), user.getPasswordHash());
        return Response.ok().build();
    }
}