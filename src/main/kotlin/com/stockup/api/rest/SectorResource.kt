package com.stockup.api.rest

import com.stockup.data.Sector
import com.stockup.services.SectorService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/sector")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class SectorResource {

    @Inject
    @field: Default
    lateinit var sectorService: SectorService

    @GET
    fun getSectors(): Multi<Sector> {
        return sectorService.getSectors()
    }

    @Path("/{id}")
    @GET
    fun getSector(@PathParam("id") id: String): Uni<Sector?> {
        return sectorService.getSector("")
    }

    @POST
    fun addSector(): Uni<Void> {
        // return sectorService.addSector(Sector()
        return Uni.createFrom().voidItem()
    }

    @Path("/{id}")
    @DELETE
    fun removeSector() {
    }

    @Path("/{id}/add-racks")
    @PUT
    @PATCH
    @POST
    fun addRacksToSector() {

    }

    @Path("/{id}/add-devices")
    @PUT
    @PATCH
    @POST
    fun addDevicesToSector() {

    }

    @Path("/{id}/remove-devices")
    @PUT
    @PATCH
    fun removeDevicesFromSector() {

    }
}