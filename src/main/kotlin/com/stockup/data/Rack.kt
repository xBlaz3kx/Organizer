package com.stockup.data

data class Rack(
    val ID: String,
    var length: Float,
    var width: Float,
    var height: Float,
    var shelves: ArrayList<Shelf> = arrayListOf(), // shelves from bottom to top
    var maxShelves: Int,
)