package eu.tutorials.mywishlistapp.ui.theme

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.tutorials.mywishlistapp.data.Wish

@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class WishDatabase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}