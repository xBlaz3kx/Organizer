package com.stockup.api.rest

import com.stockup.services.ItemService
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
    fun getItems() {
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getItem() {
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
    fun addItem() {

    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteItem() {

    }
}