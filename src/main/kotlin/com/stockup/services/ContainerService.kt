package com.stockup.services

import com.stockup.data.Container
import com.stockup.mqtt.MQTTPublisher
import com.stockup.repositories.ContainerRepository
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

    fun addContainer(container: Container) {
    }

    fun addContainerToShelf(containerId: String, shelfId: String) {
    }

    fun getItemCount(containerID: String) {
    }

    fun getItemName(containerID: String) {
    }

    fun showContainerWithItem(itemID: String) {
    }

    fun showContainerWithItemBarcode(barcode: String) {
    }

    fun updateItemCountInContainer(containerID: String, itemCount: Float) {
    }

    fun moveContainerToShelf(containerID: String, shelfId: String) {
    }
}