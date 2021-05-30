package com.stockup.services

import com.stockup.data.Shelf
import com.stockup.repositories.SectorRepository
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject


@ApplicationScoped
class ShelfService {

    @Inject
    @field: Default
    lateinit var sectorRepository: SectorRepository

    fun getShelf(shelfId: String) {}

    fun addShelf(shelf: Shelf) {}

    fun addShelfToRack(shelfId: String, rackId: String) {}

    fun deleteShelveFromRack(shelfId: String) {}

}