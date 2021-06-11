package com.innovativeapps.com.messagingapp.service;

import com.innovativeapps.com.messagingapp.manager.MessageManagerLocal;
import com.innovativeapps.com.messagingapp.pojo.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/messages")
public class MessageService {

    @Context
    HttpServletRequest request;

    @Autowired
    private MessageManagerLocal messageManager;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(@QueryParam("user_id") String userId, @QueryParam("content") String content) {
        AppMessage appMessage = messageManager.createMessage(userId, content);

        return Response.status(Response.Status.CREATED).entity(appMessage).build();
    }

}
