package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import org.bson.types.ObjectId

@MongoEntity(collection = "items")
data class Item(
    val ID: ObjectId,
    var name: String,
    var length: Float?,
    var width: Float?,
    var height: Float?,
    var weight: Float?,
    var barcode: String
) : ReactivePanacheMongoEntity()