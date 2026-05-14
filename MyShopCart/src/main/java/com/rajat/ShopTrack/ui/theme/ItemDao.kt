package com.rajat.myshopcart.ui.theme

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rajat.myshopcart.data.Item
//import com.rajat.mywishlistapp.data.Wish
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAnItem(itemEntity: Item)

    // Loads all items from the wish table
    @Query("Select * from `Wish-Table`")
    abstract fun getAllItems(): Flow<List<Item>>

    @Update
    abstract suspend fun updateAnItem(itemEntity: Item)

    @Delete
    abstract suspend fun deleteAnItem(itemEntity: Item)

    @Query("Select * from `Wish-Table` where id=:id")
    abstract fun getAnItemById(id: Long): Flow<Item>
}
