package com.stockup.api.rest

import com.stockup.services.ShelfService
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
    fun getShelves() {

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getShelf() {

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addShelf() {

    }

    @Path("/{id}/add-containers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addContainersToShelf() {

    }

    @Path("/{id}/assign-device")
    @PATCH
    @PUT
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addDeviceToShelf() {

    }
}