package com.stockup.services

import com.stockup.data.Item
import com.stockup.repositories.ItemRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class ItemService {

    @Inject
    @field: Default
    lateinit var itemRepository: ItemRepository

    fun getItem(itemId: String): Uni<Item?> {
        return itemRepository.getItem(itemId)
    }

    fun getItems(): Multi<Item> {
        return itemRepository.getItem()
    }

    fun findByBarcode(barcode: String): Multi<Item> {
        return itemRepository.find("barcode", barcode).stream()
    }

    fun addItem(item: Item): Uni<Void> {
        return itemRepository.addItem(item)
    }

    fun addItemToContainer(itemId: String, containerId: String): Uni<Void?> {
        return Uni.createFrom().nullItem()
    }

    fun deleteItem(itemId: String): Uni<Boolean> {
        return itemRepository.deleteItem(itemId)
    }
}