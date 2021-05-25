package com.stockup.repositories

import com.stockup.data.LEDController
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository

class DeviceRepository : ReactivePanacheMongoRepository<LEDController> {

}