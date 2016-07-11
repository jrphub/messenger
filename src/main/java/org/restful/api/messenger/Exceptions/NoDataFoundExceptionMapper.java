package org.restful.api.messenger.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.restful.api.messenger.model.ErrorMessage;

@Provider
public class NoDataFoundExceptionMapper implements
	ExceptionMapper<NoDataFoundException> {

    @Override
    public Response toResponse(NoDataFoundException ex) {
	ErrorMessage errMsg = new ErrorMessage(ex.getMessage(), 404,
		"http://iamjrp.com");
	return Response.status(Status.NOT_FOUND).entity(errMsg).build();
    }

}
