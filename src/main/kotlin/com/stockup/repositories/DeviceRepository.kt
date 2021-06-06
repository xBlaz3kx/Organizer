package com.stockup.repositories

import com.stockup.data.Device
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DeviceRepository : ReactivePanacheMongoRepository<Device> {

    fun getDevice(deviceId: String): Uni<Device?> {
        return findById(ObjectId(deviceId))
    }

    fun getDevices(): Multi<Device> {
        return findAll().stream()
    }

    fun addDevice(Device: Device): Uni<Void> {
        return persistOrUpdate(Device)
    }

    fun deleteDevice(DeviceId: String): Uni<Boolean> {
        return deleteById(ObjectId(DeviceId))
    }
}