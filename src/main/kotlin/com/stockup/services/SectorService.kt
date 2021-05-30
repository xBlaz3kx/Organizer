package com.stockup.services

import com.stockup.data.Sector
import com.stockup.repositories.SectorRepository
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class SectorService {

    @Inject
    @field: Default
    lateinit var sectorRepository: SectorRepository

    fun addSector(sector: Sector) {}

    fun getSectors() {}

    fun getSector(sectorID: String) {}

    fun deleteSector(sectorID: String) {}

    fun addRacksToSector(sectorID: String, racks: List<String>) {}

    fun getRacksInSector(sectorID: String) {}

    fun getDevicesInSector(sectorID: String) {}

    fun addDevicesToSector(sectorID: String, devices: List<String>) {}

    fun removeDevicesFromSector(sectorID: String, devices: List<String>) {}

}