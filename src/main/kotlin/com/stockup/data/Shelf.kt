package com.stockup.data

data class Shelf(
    val ID: String,
    var length: Float,
    var width: Float,
    var height: Float,
    var containers: ArrayList<Container> = arrayListOf() // containers from left to right
)