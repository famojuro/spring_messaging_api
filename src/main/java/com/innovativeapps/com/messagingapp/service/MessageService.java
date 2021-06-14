package com.innovativeapps.com.messagingapp.service;

import com.innovativeapps.com.messagingapp.manager.MessageManagerLocal;
import com.innovativeapps.com.messagingapp.pojo.AppMessage;
import com.innovativeapps.com.messagingapp.pojo.MessagePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Path("/messages")
public class MessageService {

    @Context
    HttpServletRequest request;
    @Context UriInfo uriInfo;

    @Autowired
    private MessageManagerLocal messageManager;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(@QueryParam("user_id") String userId, @QueryParam("content") String content) {
        AppMessage appMessage = messageManager.createMessage(userId, content);

        return Response.status(Response.Status.CREATED).entity(appMessage).build();
    }

    @GET
    @Path("/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessageById(@PathParam("message_id") String messageId) {
        AppMessage appMessage = messageManager.getMessage(messageId);
        String selfLink = uriInfo.getBaseUriBuilder()
                .path(MessageService.class, "getMessageById")
                .build()
                .toString();

        appMessage.addLink(selfLink, "self", "GET");

        return Response.ok(appMessage).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        MessagePayload appMessages = messageManager.getMessages();
        String selfLink =  uriInfo.getBaseUriBuilder().path(uriInfo.getPath()).build().toString();
        appMessages.addLink(selfLink, "self", "GET");

        return Response.ok(appMessages).build();
    }

}
