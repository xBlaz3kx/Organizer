package com.stockup.api.rest

import com.stockup.services.ContainerService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/container")
class ContainerResource {

    @Inject
    @field: Default
    lateinit var containerService: ContainerService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getContainers() {

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getContainer() {

    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addContainer() {

    }

    @Path("/{id}/add-to-shelf")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addToShelf() {

    }

    @Path("/{id}/move-to-shelf")
    @POST
    @PATCH
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun moveToShelf() {
    }

    @Path("/{id}")
    @PATCH
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateItemStock() {

    }
}