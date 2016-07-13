package org.restful.api.messenger.resources;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

/**
 * @author jpattnaik
 * 
 *         post-matching filters applied after a resource method has been
 *         selected to process the request (after request matching happens).
 *         Since these filter are applied after matching a resource method,
 *         these won't impact resource method matching process. By default all
 *         filters are post-matching filters
 * 
 *         To use this class, we need to provide username and password as
 *         "admin" in header
 *
 */

@Provider
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String username = requestContext.getHeaderString("username");
		String password = requestContext.getHeaderString("password");

		if (!("admin".equals(username) && "admin".equals(password))) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}

}
