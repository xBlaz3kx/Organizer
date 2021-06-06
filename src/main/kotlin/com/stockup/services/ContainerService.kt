package com.stockup.services

import com.stockup.data.Container
import com.stockup.mqtt.MQTTPublisher
import com.stockup.repositories.ContainerRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class ContainerService {

    @Inject
    @field: Default
    lateinit var mqttClient: MQTTPublisher

    @Inject
    @field: Default
    lateinit var containerRepository: ContainerRepository

    fun addContainer(container: Container): Uni<Void> {
        return containerRepository.addContainer(container)
    }

    fun getContainer(containerId: String): Uni<Container?> {
        return containerRepository.getContainer(containerId)
    }

    fun getContainers(): Multi<Container> {
        return containerRepository.getContainers()
    }

    fun deleteContainer(containerId: String): Uni<Boolean> {
        return containerRepository.deleteContainer(containerId)
    }

    fun addContainerToShelf(containerId: String, shelfId: String): Uni<Container?> {
        return Uni.createFrom().nullItem()
    }

    fun getItemCount(containerID: String): Uni<Int?> {
        return Uni.createFrom().nullItem()
    }

    fun getItemName(containerID: String): Uni<String?> {
        return Uni.createFrom().nullItem()
    }

    fun showContainerWithItem(itemID: String): Uni<Void?> {
        return Uni.createFrom().nullItem()
    }

    fun showContainerWithItemBarcode(barcode: String): Uni<Void?> {
        return Uni.createFrom().nullItem()
    }

    fun updateItemCountInContainer(containerID: String, itemCount: Float): Uni<String?> {
        return Uni.createFrom().nullItem()
    }

    fun moveContainerToShelf(containerID: String, shelfId: String): Uni<String?> {
        return Uni.createFrom().nullItem()
    }
}