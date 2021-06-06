package com.stockup.services

import com.stockup.data.Sector
import com.stockup.repositories.SectorRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class SectorService {

    @Inject
    @field: Default
    lateinit var sectorRepository: SectorRepository

    fun addSector(sector: Sector): Uni<Void> {
        return sectorRepository.addSector(sector)
    }

    fun getSectors(): Multi<Sector> {
        return sectorRepository.getSectors()
    }

    fun getSector(sectorID: String): Uni<Sector?> {
        return sectorRepository.getSector(sectorID)
    }

    fun deleteSector(sectorID: String): Uni<Boolean> {
        return sectorRepository.deleteSector(sectorID)
    }

    fun addRacksToSector(sectorID: String, racks: List<String>) {
        sectorRepository.findById(ObjectId(sectorID))
    }

    fun getRacksInSector(sectorID: String) {}

    fun getDevicesInSector(sectorID: String) {}

    fun addDevicesToSector(sectorID: String, devices: List<String>) {}

    fun removeDevicesFromSector(sectorID: String, devices: List<String>) {}

}