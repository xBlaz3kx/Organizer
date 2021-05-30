package com.stockup.repositories

import com.stockup.data.Rack
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RackRepository : ReactivePanacheMongoRepository<Rack> {
}