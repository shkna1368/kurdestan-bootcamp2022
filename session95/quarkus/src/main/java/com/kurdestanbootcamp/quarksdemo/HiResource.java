
package com.kurdestanbootcamp.quarksdemo;

import javax.ws.rs.GET;


import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api")
public class HiResource {

    @GET
    @Path("/hi")
    public Response findByColor(@PathParam String color) {


     return    Response.ok().entity("Hi quarqus from kubernetes").build();

    }
}

