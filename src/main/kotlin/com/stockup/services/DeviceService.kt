package com.stockup.services

import com.stockup.data.Device
import com.stockup.mqtt.MQTTPublisher
import com.stockup.repositories.DeviceRepository
import io.smallrye.mutiny.Multi
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class DeviceService {

    @Inject
    @field: Default
    lateinit var mqttClient: MQTTPublisher

    @Inject
    @field: Default
    lateinit var deviceRepository: DeviceRepository

    fun getDevices(): Multi<Device> {
        return Multi.createFrom().empty()
    }

    fun getDeviceWithId(deviceId: String) {
    }

    fun addDevice(device: Device) {
    }

    fun addDeviceToSector(deviceId: String, sectorId: String) {
    }

    fun addRacksToManage(deviceId: String, rackId: String) {
    }

    fun removeShelfFromDevice(deviceId: String, shelfId: String) {
    }

    fun deleteDevice(deviceId: String) {
    }
}