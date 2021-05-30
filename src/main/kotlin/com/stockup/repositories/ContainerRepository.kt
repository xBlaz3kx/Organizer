package com.stockup.repositories

import com.stockup.data.Container
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ContainerRepository : ReactivePanacheMongoRepository<Container> {
}