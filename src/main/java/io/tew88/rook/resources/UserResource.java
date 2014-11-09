package io.tew88.rook.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
public class UserResource {
    
    @GET
    public String sayHelloWorld() {
        return "Hello, World!";
    }
}