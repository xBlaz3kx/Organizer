package com.stockup.repositories

import com.stockup.data.Item
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ItemRepository : ReactivePanacheMongoRepository<Item> {

}