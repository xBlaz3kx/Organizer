package com.stockup.repositories

import com.stockup.data.Device
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DeviceRepository : ReactivePanacheMongoRepository<Device> {

}