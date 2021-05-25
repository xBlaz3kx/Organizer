package com.stockup.api.rest

import com.stockup.services.SectorService
import io.smallrye.mutiny.Uni
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/sector")
class SectorResource {

    @Inject
    @field: Default
    lateinit var sectorService: SectorService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): Uni<Void> = Uni.createFrom().voidItem()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getSectors() {

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getSector() {

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addSector() {

    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun removeSector() {

    }

    @Path("/{id}/add-rack")
    @PUT
    @PATCH
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addRackToSector() {

    }
}