package com.rajat.myshopcart.ui.theme

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rajat.myshopcart.data.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}