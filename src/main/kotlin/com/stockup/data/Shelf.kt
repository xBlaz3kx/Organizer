package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import org.bson.types.ObjectId

@MongoEntity(collection = "shelves")
data class Shelf(
    val ID: ObjectId,
    var length: Float?,
    var width: Float?,
    var height: Float?,
    var containers: ArrayList<Container> = arrayListOf() // containers from left to right
) : ReactivePanacheMongoEntity()