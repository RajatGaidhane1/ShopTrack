package eu.tutorials.mywishlistapp.ui.theme

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.tutorials.mywishlistapp.data.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}