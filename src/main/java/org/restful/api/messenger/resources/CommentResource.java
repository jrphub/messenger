package org.restful.api.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

    @GET
    @Path("/{commentId}")
    public String getComment(@PathParam("messageId") long messageId,
	    @PathParam("commentId") long commentId) {
	return "Comment id : " + commentId + " of message id :" + messageId;

    }
}
