package com.stockup.repositories

import com.stockup.data.Container
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository

class ContainerRepository : ReactivePanacheMongoRepository<Container> {
}