package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
import org.bson.codecs.pojo.annotations.BsonId

@MongoEntity(collection = "devices")
data class LEDController(
    @BsonId val deviceId: String,
    var racksControlled: ArrayList<String> = arrayListOf() //IDs of racks that will have a device with LEDs
) : PanacheMongoEntityBase()
