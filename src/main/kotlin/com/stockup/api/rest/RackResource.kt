package com.stockup.api.rest

import com.stockup.data.Rack
import com.stockup.services.RackService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
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
    fun getRacks(): Multi<Rack> {
        return rackService.getRacks()
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getRack(@PathParam("id") id: String): Uni<Rack?> {
        return rackService.getRack(id)
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addRack(rack: Rack): Uni<Void> {
        return rackService.addRack(rack)
    }

    @Path("/{id}/add-shelves")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addShelvesToRack() {

    }

    @Path("/{id}/remove-shelves")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun removeShelvesFromRack() {

    }
}