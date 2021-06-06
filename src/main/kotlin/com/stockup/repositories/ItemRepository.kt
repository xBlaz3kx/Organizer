package com.stockup.repositories

import com.stockup.data.Item
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ItemRepository : ReactivePanacheMongoRepository<Item> {

    fun getItem(): Multi<Item> {
        return findAll().stream()
    }

    fun getItem(ItemId: String): Uni<Item?> {
        return findById(ObjectId(ItemId))
    }

    fun addItem(Item: Item): Uni<Void> {
        return persistOrUpdate(Item)
    }

    fun deleteItem(ItemId: String): Uni<Boolean> {
        return deleteById(ObjectId(ItemId))
    }
}