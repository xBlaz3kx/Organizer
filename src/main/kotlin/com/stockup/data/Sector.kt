package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import org.bson.types.ObjectId

@MongoEntity(collection = "sectors")
data class Sector(
    var ID: ObjectId,
    var racks: ArrayList<Rack> = arrayListOf(), // IDs of rack in a sector
    var devices: ArrayList<String> = arrayListOf() // IDs of RPi's that control racks/LEDs in the sector
)