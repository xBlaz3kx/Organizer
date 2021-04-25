package com.stockup.data

data class Sector(
    var ID: String,
    var racks: ArrayList<Rack> = arrayListOf()
)