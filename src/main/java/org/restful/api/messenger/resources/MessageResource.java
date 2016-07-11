package org.restful.api.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.restful.api.messenger.Exceptions.NoDataFoundException;
import org.restful.api.messenger.model.Message;
import org.restful.api.messenger.services.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_XML)
@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class MessageResource {

    MessageService msgService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilters msgFilters) {

	if (msgFilters.getYear() > 0) {
	    return msgService.msgForYear(msgFilters.getYear());
	}

	if (msgFilters.getStart() > 0 && msgFilters.getSize() > 0) {
	    return msgService.getMsgPaginated(msgFilters.getStart(),
		    msgFilters.getSize());
	}

	return msgService.getAllMessages();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
	Message newMsg = msgService.addMessage(message);
	String newId = String.valueOf(newMsg.getId());
	URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
	return Response.created(uri).entity(newMsg).build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long msgId, Message msg) {
	msg.setId(msgId);
	return msgService.updateMessage(msg);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long msgId) {
	Message msg = msgService.getMessage(msgId);
	if (msg == null) {
	    throw new NoDataFoundException("For message with id " + msgId
		    + " : No Data Found");
	}

	return msg;
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long msgId) {
	msgService.removeMessage(msgId);
    }

    @Path("/{messageId}/comments")
    public CommentResource getComments() {
	return new CommentResource();
    }
}
