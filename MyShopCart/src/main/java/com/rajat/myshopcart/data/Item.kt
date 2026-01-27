package eu.rajat.myshopcart.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wish-Table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "Item-Title")
    val title: String = "",

    @ColumnInfo(name = "Item-Desc")
    val description: String = ""
)

object DummyItem {
    val itemList = listOf(
        Item(title = "Google Watch 2", description = "An android Watch"),
        Item(title = "Oculus Quest 2", description = "A VR headset for playing games"),
        Item(title = "A Sci-fi Book", description = "A science fiction book from any best seller"),
        Item(title = "Bean bag", description = "A comfy bean bag to substitute for a chair")
    )
}
