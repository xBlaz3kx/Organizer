package com.stockup.repositories

import com.stockup.data.Shelf
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository

class ShelfRepository : ReactivePanacheMongoRepository<Shelf> {
}