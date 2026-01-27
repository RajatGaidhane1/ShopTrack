# MyShopCart

**Android-only Kotlin app — Jetpack Compose · MVVM · Room · Kotlin Flow**

A clean, offline-first shopping list application built with modern Android development practices. Designed for clarity, maintainability, and portfolio-ready structure — ideal as a learning project or production prototype.

---

## Key Features
- Add, update, and delete items (full CRUD functionality).  
- Reactive UI using `StateFlow` / `Flow` for instant updates.  
- Local persistence with Room (Entity / DAO).  
- Smooth navigation using Jetpack Navigation (`navigation-compose`).  
- MVVM architecture with a Repository layer for clean separation of concerns.  
- Offline-first: fully functional without an internet connection.

---

## Tech Stack
Kotlin · Jetpack Compose · MVVM · Room · Kotlin Flow · Jetpack Navigation · Android Studio · Gradle · Git

---

## Quick Start

```bash
git clone https://github.com/RajatGaidhane1/MyShopCart.git
cd MyShopCart

1. Open the project in Android Studio (Arctic Fox or later recommended).
2. Let Gradle sync and download dependencies.
3. Run on an emulator or physical device (API 21+).

Project Layout (overview)

# MyShopCart

**Android-only Kotlin app — Jetpack Compose · MVVM · Room · Kotlin Flow**

A clean, offline-first shopping list application built with modern Android development practices. Designed for clarity, maintainability, and portfolio-ready structure — ideal as a learning project or production prototype.

---

## Key Features
- Add, update, and delete items (full CRUD functionality).  
- Reactive UI using `StateFlow` / `Flow` for instant updates.  
- Local persistence with Room (Entity / DAO).  
- Smooth navigation using Jetpack Navigation (`navigation-compose`).  
- MVVM architecture with a Repository layer for clean separation of concerns.  
- Offline-first: fully functional without an internet connection.

---

## Tech Stack
Kotlin · Jetpack Compose · MVVM · Room · Kotlin Flow · Jetpack Navigation · Android Studio · Gradle · Git

---

## Quick Start

```bash
git clone https://github.com/RajatGaidhane1/MyShopCart.git
cd MyShopCart

1. Open the project in Android Studio (Arctic Fox or later recommended).
2. Let Gradle sync and download dependencies.
3. Run on an emulator or physical device (API 21+).
Project Layout (overview)
/app
  /src/main/java/com/rajat/myshopcart
    /ui           # Compose screens & UI components
    /viewmodel    # ViewModels exposing StateFlow
    /data
      /local      # Room database, ItemDao, Item entity
    /repository   # Repository for data access abstraction
  /res
AndroidManifest.xml
build.gradle
Example Snippets
ViewModel
fun addItem(item: Item){
    viewModelScope.launch(Dispatchers.IO) {
        itemRepository.addAWish(wish = item)
    }
}

fun deleteItem(item: Item){
    viewModelScope.launch(Dispatchers.IO) {
        itemRepository.deleteAWish(wish = item)
        getAllItems = itemRepository.getWishes()
    }
}
Sample DAO
@Dao
abstract class ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(itemEntity: Item)

    @Query("SELECT * FROM `item-table`")
    abstract fun getAllWishes(): Flow<List<Item>>

    @Update
    abstract suspend fun updateAWish(itemEntity: Item)
}
Sample Repositoryclass WishRepository(private val itemDao: ItemDao) {

    suspend fun addAWish(item: Item){
        itemDao.addAWish(item)
    }

    fun getWishes(): Flow<List<Item>> = itemDao.getAllWishes()

    suspend fun updateAWish(item: Item){
        itemDao.updateAWish(item)
    }

    suspend fun deleteAWish(item: Item){
        itemDao.deleteAWish(item)
    }
}
Contributing
This is a personal learning project (sole developer). Contributions and suggestions are welcome:
Fork the repository
Create a feature branch: feat/your-feature
Commit your changes and open a Pull Request
Suggested improvements:
Search & filtering, categories/tags
Cloud sync (Firebase / REST) for cross-device persistence
Unit & UI tests, CI (GitHub Actions)
Accessibility enhancements and localization
Contact
Built by Rajat Gaidhane — GitHub: RajatGaidhane1







