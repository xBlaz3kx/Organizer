package com.stockup.services

import com.stockup.data.Rack
import com.stockup.data.Shelf
import com.stockup.repositories.RackRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class RackService {

    @Inject
    @field: Default
    lateinit var rackRepository: RackRepository

    fun addRack(rack: Rack): Uni<Void> {
        return rackRepository.persistOrUpdate(rack)
    }

    fun getRack(rackId: String): Uni<Rack?> {
        return rackRepository.getRack(rackId)
    }

    fun getRacks(): Multi<Rack> {
        return rackRepository.getRacks()
    }

    fun addRackToSector(rack: Rack, sectorId: String) {
    }

    fun deleteRackFromSector(rackId: String, sectorId: String) {}

    fun deleteRack(rackId: String): Uni<Boolean> {
        return rackRepository.deleteRack(rackId)
    }

    fun updateRackShelves(rackId: String, shelves: List<Shelf>) {
    }

    fun getShelvesFromRack(rackId: String) {}

}