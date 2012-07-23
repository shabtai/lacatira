package com.lacatira.rest;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/16/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
@WebService
@Path("/scenario")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface Scenario {

    @POST
	@Path("/")
//    @PreAuthorize("hasRole('ROLE_EVENT_MANAGER')")
    public void addScenario(int specialEvent)
			throws Exception;
}
