package eu.rajat.myshopcart.data


import android.content.Context
import androidx.room.Room
import eu.rajat.myshopcart.ui.theme.ItemDatabase

object Graph {
    lateinit var database: ItemDatabase

    val itemRepository by lazy {
        ItemRepository(itemDao = database.itemDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            ItemDatabase::class.java,
            "wishlist.db"
        ).build()
    }
}
