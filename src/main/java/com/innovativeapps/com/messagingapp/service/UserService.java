package com.innovativeapps.com.messagingapp.service;

import com.innovativeapps.com.messagingapp.manager.UserManagerLocal;
import com.innovativeapps.com.messagingapp.pojo.AppUser;
import com.innovativeapps.com.messagingapp.pojo.UserPayload;
import com.innovativeapps.com.messagingapp.util.exception.AppException;
import com.innovativeapps.com.messagingapp.util.exception.GeneralAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("/users")
public class UserService {

    @Context
    HttpServletRequest request;

    @Autowired
    private UserManagerLocal userManager;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@QueryParam("user_name") String userName,
                               @QueryParam("gender") String gender) throws GeneralAppException {
        AppUser appUser = userManager.createUser(userName, gender);

        return Response.ok(appUser).build();
    }

    @GET
    @Path("/{user_id}")
    public Response getUser(@PathParam("user_id") String userId) throws AppException {
        AppUser appUser = userManager.getUser(userId);

        return Response.ok(appUser).build();
    }

    @PUT
    @Path("/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("user_id") String userId,
                               @QueryParam("user_name") String userName,
                               @QueryParam("gender") String gender) throws AppException {
        AppUser appUser = userManager.updateUser(userId, userName, gender);

        return Response.status(Response.Status.CREATED).entity(appUser).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        UserPayload appUsers = userManager.getUsers();

        return Response.ok(appUsers).build();
    }

}
