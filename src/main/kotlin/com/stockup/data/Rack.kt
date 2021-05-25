package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import org.bson.types.ObjectId

@MongoEntity(collection = "racks")
data class Rack(
    val ID: ObjectId,
    var length: Float?,
    var width: Float?,
    var height: Float?,
    var shelves: ArrayList<Shelf> = arrayListOf(), //ID of shelves, added from bottom to top
    var maxShelves: Int = 1 // Max shelves per rack
) : ReactivePanacheMongoEntity()