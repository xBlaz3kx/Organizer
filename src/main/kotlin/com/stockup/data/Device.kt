package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import org.bson.codecs.pojo.annotations.BsonId

@MongoEntity(collection = "devices")
data class Device(
    @BsonId val deviceId: String,
    var shelvesControlled: ArrayList<String> = arrayListOf() //IDs of shelves that will have a device with LEDs; should be sorted like LEDs are configured
) : ReactivePanacheMongoEntity()
