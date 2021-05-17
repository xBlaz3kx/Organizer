package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import org.bson.types.ObjectId

@MongoEntity(collection = "racks")
data class Rack(
    val ID: ObjectId,
    var length: Float,
    var width: Float,
    var height: Float,
    var shelves: ArrayList<Shelf> = arrayListOf(), //ID of shelves, added from bottom to top
    var maxShelves: Int // Max shelves per rack
)