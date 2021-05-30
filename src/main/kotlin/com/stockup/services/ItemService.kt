package com.stockup.services

import com.stockup.data.Item
import com.stockup.mqtt.MQTTPublisher
import com.stockup.repositories.ItemRepository
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class ItemService {

    @Inject
    @field: Default
    lateinit var itemRepository: ItemRepository

    fun getItem(itemID: String) {}

    fun getItems() {}

    fun findByBarcode(itemID: String) {}

    fun addItem(item: Item) {}

    fun addItemToContainer(itemID: String, containerId: String) {}

    fun deleteItem(itemID: String) {}
}