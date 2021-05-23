package com.stockup.api.rest

import com.stockup.services.DeviceService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/device")
class DeviceManagementResource {

    @Inject
    @field: Default
    lateinit var deviceService: DeviceService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getDevices() {

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getDevice() {

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addDevice() {

    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteDevice() {

    }

    @Path("/{id}/add-shelves")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    fun addShelvesToDevice() {

    }


    @Path("/{id}/reassign")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    fun reassignToShelf() {

    }

}