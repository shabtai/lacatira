package com.lacatira.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/auth")
public interface AuthTest {
	
	// an empty method that test user login.
	// This method will return OK code if login was successful
    @GET
    @Path("/")
    public void auth();
}
