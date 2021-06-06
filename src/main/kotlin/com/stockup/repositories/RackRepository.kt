package com.stockup.repositories

import com.stockup.data.Rack
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RackRepository : ReactivePanacheMongoRepository<Rack> {

    fun getRacks(): Multi<Rack> {
        return findAll().stream()
    }

    fun getRack(rackId: String): Uni<Rack?> {
        return findById(ObjectId(rackId))
    }

    fun addRack(rack: Rack): Uni<Void> {
        return persistOrUpdate(rack)
    }

    fun deleteRack(rackId: String): Uni<Boolean> {
        return deleteById(ObjectId(rackId))
    }
}