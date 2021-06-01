package com.innovativeapps.com.messagingapp.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api/messages")
public class MessageService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetings() {
        String response = "Hello World";

        return Response.ok(response).build();
    }

}
