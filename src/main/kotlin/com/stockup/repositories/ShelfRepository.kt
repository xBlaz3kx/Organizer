package com.stockup.repositories

import com.stockup.data.Shelf
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ShelfRepository : ReactivePanacheMongoRepository<Shelf> {

    fun getShelves(): Multi<Shelf> {
        return findAll().stream()
    }

    fun getShelf(ShelfId: String): Uni<Shelf?> {
        return findById(ObjectId(ShelfId))
    }

    fun addShelf(Shelf: Shelf): Uni<Void> {
        return persistOrUpdate(Shelf)
    }

    fun deleteShelf(ShelfId: String): Uni<Boolean> {
        return deleteById(ObjectId(ShelfId))
    }
}