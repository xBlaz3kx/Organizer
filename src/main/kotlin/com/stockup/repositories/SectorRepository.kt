package com.stockup.repositories

import com.stockup.data.Sector
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository

class SectorRepository : ReactivePanacheMongoRepository<Sector> {
}