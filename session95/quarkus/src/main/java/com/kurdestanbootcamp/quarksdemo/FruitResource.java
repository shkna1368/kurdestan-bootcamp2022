package com.kurdestanbootcamp.quarksdemo;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.core.Response;



@Path("/fruits")
public class FruitResource {


    private final FruitService fruitService;
    private final FruitMapper mapper;

    public FruitResource(FruitService fruitService, FruitMapper mapper) {
        this.fruitService = fruitService;
        this.mapper=mapper;
    }

    @GET
    public Response  findAll() {

        return    Response.ok().entity(mapper.toDTOs(fruitService.findAll())).build();

    }


    @APIResponses(value = {@APIResponse(responseCode = "200",description = "A response with no content")})
    @Operation(summary = "Say Hello World")
@GET
@Path("/hi")

    public Response  findAll2() {
        return Response.ok().entity("hi2233").build();
    }


    @DELETE
    @Path("{id}")
    public Response  delete(@PathParam long id) {
        fruitService.delete(id);
        return    Response.ok().build();

    }



    @APIResponses(value = {@APIResponse(responseCode = "201",description = "create new fruit")})
    @Operation(summary = "Create new fruit")
    @POST
    public Response  create(@Valid FruitDTO fruitDTO)  {

     fruitService.create( mapper.toEntity(fruitDTO));

      return   Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/id/{id}/color/{color}")
    public Response  changeColor(@PathParam Long id, @PathParam String color) {


        return    Response.ok().entity(mapper.toDTO(fruitService.changeColor(id,color))).build();


    }

    @GET
    @Path("/color/{color}")
    public Response findByColor(@PathParam String color) {


     return    Response.ok().entity(mapper.toDTOs(fruitService.findByColor(color))).build();

    }
}