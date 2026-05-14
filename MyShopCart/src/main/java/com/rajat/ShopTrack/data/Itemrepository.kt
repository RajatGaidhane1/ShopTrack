package com.rajat.myshopcart.data

import com.rajat.myshopcart.ui.theme.ItemDao
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemDao: ItemDao) {

    suspend fun addAnItem(item: Item) {
        itemDao.addAnItem(item)
    }

    fun getItems(): Flow<List<Item>> = itemDao.getAllItems()

    fun getAnItemById(id: Long): Flow<Item> {
        return itemDao.getAnItemById(id)
    }

    suspend fun updateAnItem(item: Item) {
        itemDao.updateAnItem(item)
    }

    suspend fun deleteAnItem(item: Item) {
        itemDao.deleteAnItem(item)
    }
}
