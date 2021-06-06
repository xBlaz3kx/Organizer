package com.stockup.api.rest

import com.stockup.data.Container
import com.stockup.services.ContainerService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/container")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ContainerResource {

    @Inject
    @field: Default
    lateinit var containerService: ContainerService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getContainers(): Multi<Container> {
        return containerService.getContainers()
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getContainer(@PathParam("id") id: String): Uni<Container?> {
        return containerService.getContainer(id)
    }

    @Path("/")
    @POST
    fun addContainer(container: Container): Uni<Void> {
        return containerService.addContainer(container)
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteContainer(@PathParam("id") id: String): Uni<Boolean> {
        return containerService.deleteContainer(id)
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