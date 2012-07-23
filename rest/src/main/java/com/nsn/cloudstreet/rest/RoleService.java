package com.nsn.cloudstreet.rest;


import com.nsn.cloudstreet.users.model.Role;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/management/roles")
@Produces(MediaType.APPLICATION_JSON)
public interface RoleService {

    @Path("/")
    @GET
    public List<Role> getRoles() throws Exception;

    @GET
    @Path("/byname/{name}")
    public Role getRole(@PathParam("name") String roleId);
    
    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Role saveRole(Role role) throws Exception;
}
