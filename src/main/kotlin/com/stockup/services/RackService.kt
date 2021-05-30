package com.stockup.services

import com.stockup.data.Rack
import com.stockup.data.Shelf
import com.stockup.repositories.RackRepository
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class RackService {

    @Inject
    @field: Default
    lateinit var rackRepository: RackRepository

    fun getRack(rackId: String) {}

    fun getRacks() {}

    fun addRackToSector(rack: Rack, sectorId: String) {}

    fun deleteRackFromSector(rackId: String, sectorId: String) {}

    fun deleteRack(rackId: String) {}

    fun updateRackShelves(rackId: String, shelves: List<Shelf>) {
    }

    fun getShelvesFromRack(rackId: String) {}

}