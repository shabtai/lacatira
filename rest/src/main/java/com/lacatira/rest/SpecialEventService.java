package com.lacatira.rest;

import com.lacatira.specialevents.model.SpecialEvent;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;



@WebService
@Path("/events")
@Produces({MediaType.APPLICATION_JSON})
public interface SpecialEventService {

	@POST
	@Path("/")
    @PreAuthorize("hasRole('ROLE_EVENT_MANAGER')")
	@Consumes({MediaType.APPLICATION_JSON})
    public SpecialEvent addSpecialEvent(SpecialEvent specialEvent)
			throws Exception;

	
	/**
     * Gets a list of events according to given parameters and 
     * @param userId     	user id, parameter to filter, if null will be ignored while fetching events
     * @param ids     	list of event ids, parameter to filter, if null will be ignored
     * 
     * @return list of Events that fetch given criteria, empty List if no such events
     * @throws Exception
     */
    @GET
    @Path("")
    @PreAuthorize("hasAnyRole('ROLE_EVENT_MANAGER', 'ROLE_PROVIDER', 'ROLE_CONSUMER')")
	public List<SpecialEvent> getEvents(@QueryParam("userId") Long userId,
                                        @QueryParam("id") List<Long> ids,
                                        @QueryParam("fromStartTime") Long fromStartTime,
                                        @QueryParam("toStartTime") Long toStartTime,
                                        @QueryParam("name") String eventName) throws Exception;

	@GET
	@Path("/{id}")
	@PreAuthorize("hasRole('ROLE_EVENT_MANAGER')")
	public SpecialEvent getEventById(@PathParam("id") Long eventId) throws Exception;


}

