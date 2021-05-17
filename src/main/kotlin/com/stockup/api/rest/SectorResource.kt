package com.stockup.api.rest

import io.smallrye.mutiny.Uni
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/sector")
class SectorResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/oooga")
    fun hello(): Uni<Void> = Uni.createFrom().voidItem()
}