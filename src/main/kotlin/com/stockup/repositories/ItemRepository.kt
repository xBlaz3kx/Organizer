package com.stockup.repositories

import com.stockup.data.Item
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository

class ItemRepository : ReactivePanacheMongoRepository<Item> {

}