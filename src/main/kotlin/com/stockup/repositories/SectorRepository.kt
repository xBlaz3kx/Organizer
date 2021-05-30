package com.stockup.repositories

import com.stockup.data.Sector
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SectorRepository : ReactivePanacheMongoRepository<Sector> {
}