package com.stockup.api.rest

import com.stockup.data.Device
import com.stockup.services.DeviceService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/device")
class DeviceManagementResource {

    @Inject
    @field: Default
    lateinit var deviceService: DeviceService

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getDevices(): Multi<Device> {
        return deviceService.getDevices()
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getDevice(): Uni<Device?> {
        return deviceService.getDeviceWithId("")
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addDevice(): Uni<Void> {
        return deviceService.addDevice(Device("", ArrayList()))
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteDevice(): Uni<Boolean> {
        return deviceService.deleteDevice("")
    }

    @Path("/{id}/add-shelves")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    fun addShelvesToDevice() {

    }

    @Path("/{id}/remove-shelves")
    @POST
    @PUT
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    fun removeShelfFromDevice() {

    }

}