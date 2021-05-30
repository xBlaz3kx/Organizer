package com.stockup.api.rest

import com.stockup.services.SectorService
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

    @Path("/{id}/add-racks")
    @PUT
    @PATCH
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addRacksToSector() {

    }

    @Path("/{id}/add-devices")
    @PUT
    @PATCH
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addDevicesToSector() {

    }

    @Path("/{id}/remove-devices")
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun removeDevicesFromSector() {

    }
}