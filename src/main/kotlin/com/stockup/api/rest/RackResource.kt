package com.stockup.api.rest

import com.stockup.services.RackService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/rack")
class RackResource {

    @Inject
    @field: Default
    lateinit var rackService: RackService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getRacks() {

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getRack() {

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addRack() {

    }

    @Path("/{id}/add-shelves")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    fun addShelvesToRack() {

    }
}