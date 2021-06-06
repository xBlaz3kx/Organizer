package com.stockup.services

import com.stockup.data.Shelf
import com.stockup.repositories.ShelfRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject


@ApplicationScoped
class ShelfService {

    @Inject
    @field: Default
    lateinit var shelfRepository: ShelfRepository

    fun getShelf(shelfId: String): Uni<Shelf?> {
        return shelfRepository.getShelf(shelfId)
    }

    fun getShelves(): Multi<Shelf> {
        return shelfRepository.getShelves()
    }

    fun deleteShelve(shelfId: String): Uni<Boolean> {
        return shelfRepository.deleteShelf(shelfId)
    }

    fun addShelf(shelf: Shelf): Uni<Void> {
        return shelfRepository.addShelf(shelf)
    }

    fun addShelfToRack(shelfId: String, rackId: String) {
    }

    fun deleteShelveFromRack(shelfId: String) {}

}