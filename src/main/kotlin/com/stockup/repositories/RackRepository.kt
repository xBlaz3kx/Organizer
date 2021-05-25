package com.stockup.repositories

import com.stockup.data.Rack
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository

class RackRepository : ReactivePanacheMongoRepository<Rack> {
}