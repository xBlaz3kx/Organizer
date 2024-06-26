package com.stockup.api.rest

import com.stockup.data.Item
import com.stockup.services.ItemService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/item")
class ItemResource {

    @Inject
    @field: Default
    lateinit var itemService: ItemService

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getItems(): Multi<Item> {
        return itemService.getItems()
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getItem(@PathParam("id") id: String): Uni<Item?> {
        return itemService.getItem(id)
    }

    @Path("/find-by-barcode/{barcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findByBarcode() {
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findItem() {

    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addItem(item: Item): Uni<Void> {
        return itemService.addItem(item)
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteItem(@PathParam("id") id: String): Uni<Boolean> {
        return itemService.deleteItem(id)
    }
}