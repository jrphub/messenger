package org.restful.api.messenger.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

	@POST
	@Path("/add")
	public Response addUser(@FormParam("username") String username, @FormParam("emailid") String emailid,
			@FormParam("password") String password) {
		return Response.status(200).entity("User is registered with Username: " + username + " Email id : " + emailid)
				.build();
	}
}
