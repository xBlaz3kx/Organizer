package com.stockup.data

data class Container(
    val ID: String,
    var length: Float,
    var width: Float,
    var height: Float,
    var item: Item,
    var itemStock: Float
)
