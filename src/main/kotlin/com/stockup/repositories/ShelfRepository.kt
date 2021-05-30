package com.stockup.repositories

import com.stockup.data.Shelf
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ShelfRepository : ReactivePanacheMongoRepository<Shelf> {
}