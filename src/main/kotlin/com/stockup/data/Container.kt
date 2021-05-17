package com.stockup.data

import io.quarkus.mongodb.panache.MongoEntity
import org.bson.types.ObjectId

@MongoEntity(collection = "containers")
data class Container(
    val ID: ObjectId,
    var length: Float,
    var width: Float,
    var height: Float,
    var item: Item,
    var itemStock: Float
)
