package com.stockup.api.rest

import com.stockup.data.Shelf
import com.stockup.services.ShelfService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/shelf")
class ShelfResource {

    @Inject
    @field: Default
    lateinit var shelfService: ShelfService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getShelves(): Multi<Shelf> {
        return shelfService.getShelves()
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getShelf(@PathParam("id") id: String): Uni<Shelf?> {
        return shelfService.getShelf(id)
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addShelf(shelf: Shelf): Uni<Void> {
        return shelfService.addShelf(shelf)
    }

    @Path("/{id}/add-containers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addContainersToShelf() {

    }

    @Path("/{id}/assign-device")
    @PATCH
    @PUT
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addDeviceToShelf() {

    }
}