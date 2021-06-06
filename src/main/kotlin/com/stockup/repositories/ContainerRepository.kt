package com.stockup.repositories

import com.stockup.data.Container
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ContainerRepository : ReactivePanacheMongoRepository<Container> {

    fun getContainer(containerId: String): Uni<Container?> {
        return findById(ObjectId(containerId))
    }

    fun getContainers(): Multi<Container> {
        return findAll().stream()
    }

    fun addContainer(Container: Container): Uni<Void> {
        return persistOrUpdate(Container)
    }

    fun deleteContainer(ContainerId: String): Uni<Boolean> {
        return deleteById(ObjectId(ContainerId))
    }

}