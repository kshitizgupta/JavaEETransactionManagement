package com.kshitiz.api;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/user")
public class UserResource {
    private static Logger LOG = Logger.getLogger(UserResource.class.getName());

    private final String OK_RESPONSE = "OK";

    @Inject
    UserService userService;

    @Path("1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String createUsersCallingDaoWithOneUserEachTime() {
        LOG.info("***************without batch***************");

        userService.insertUsers();

        LOG.info("Resource job done");
        return OK_RESPONSE;
    }

    @GET
    @Path("/edit")
    public String editUsers(@QueryParam("start") int start, @QueryParam("end") int end) {
        userService.batchJob(start, end);
        return OK_RESPONSE;
    }
}
