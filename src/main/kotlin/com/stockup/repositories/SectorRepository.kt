package com.stockup.repositories

import com.stockup.data.Sector
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SectorRepository : ReactivePanacheMongoRepository<Sector> {

    fun getSectors(): Multi<Sector> {
        return findAll().stream()
    }

    fun getSector(SectorId: String): Uni<Sector?> {
        return findById(ObjectId(SectorId))
    }

    fun addSector(Sector: Sector): Uni<Void> {
        return persistOrUpdate(Sector)
    }

    fun deleteSector(SectorId: String): Uni<Boolean> {
        return deleteById(ObjectId(SectorId))
    }
}