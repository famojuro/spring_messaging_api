package com.innovativeapps.com.messagingapp.service;

import com.innovativeapps.com.messagingapp.manager.UserManagerLocal;
import com.innovativeapps.com.messagingapp.pojo.AppUser;
import com.innovativeapps.com.messagingapp.pojo.UserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/users")
public class UserService {

    @Autowired
    private UserManagerLocal userManager;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@QueryParam("user_name") String userName, @QueryParam("gender") String gender) throws Exception {
        AppUser appUser = userManager.createUser(userName, gender);

        return Response.ok(appUser).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        UserPayload appUsers = userManager.getUsers();

        return Response.ok(appUsers).build();
    }

}
