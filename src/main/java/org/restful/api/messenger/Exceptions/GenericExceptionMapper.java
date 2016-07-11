package org.restful.api.messenger.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.restful.api.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
	ErrorMessage errMsg = new ErrorMessage(ex.getMessage(), 500,
		"http://iamjrp.com");
	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errMsg)
		.build();
    }

}
