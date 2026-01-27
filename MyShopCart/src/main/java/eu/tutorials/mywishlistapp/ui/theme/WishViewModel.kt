package eu.tutorials.mywishlistapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.mywishlistapp.data.Graph
import eu.tutorials.mywishlistapp.data.Item
import eu.tutorials.mywishlistapp.data.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ItemViewModel(
    private val itemRepository: ItemRepository = Graph.itemRepository
) : ViewModel() {

    var itemTitleState by mutableStateOf("")
    var itemDescriptionState by mutableStateOf("")

    fun onItemTitleChanged(newString: String) {
        itemTitleState = newString
    }

    fun onItemDescriptionChanged(newString: String) {
        itemDescriptionState = newString
    }

    lateinit var getAllItems: Flow<List<Item>>

    init {
        viewModelScope.launch {
            getAllItems = itemRepository.getItems() // was getWishes()
        }
    }

    fun addItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.addAnItem(item) // was addAWish()
        }
    }

    fun getAnItemById(id: Long): Flow<Item> {
        return itemRepository.getAnItemById(id) // was getAWishById()
    }

    fun updateItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.updateAnItem(item) // was updateAWish()
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.deleteAnItem(item) // was deleteAWish()
            getAllItems = itemRepository.getItems() // was getWishes()
        }
    }
}
