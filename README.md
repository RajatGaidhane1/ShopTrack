# Wishlist

**Android-only Kotlin app — Jetpack Compose · MVVM · Room · Kotlin Flow**

A simple, offline-first wishlist application built with modern Android tooling. Focused on clarity, maintainability, and easy extensibility — ideal as a learning project or portfolio piece.

---

## Key features
- Create, edit, and delete wishes (CRUD).  
- Reactive UI using `StateFlow` / `Flow` for immediate updates.  
- Local, offline-first persistence with Room (Entity / DAO).  
- Navigation with Jetpack Navigation (navigation-compose).  
- MVVM architecture with a Repository layer for clean separation of concerns.

---

## Tech stack
Kotlin · Jetpack Compose · MVVM · Room · Kotlin Flow · Jetpack Navigation · Android Studio · Gradle · Git

---

## Quick start
```bash
git clone https://github.com/RajatGaidhane1/Wishlist_App.git
cd Wishlist_App

1. Open the project in Android Studio (Arctic Fox or later recommended).
2. Let Gradle sync and download dependencies.
3. Run on an emulator or physical device (API 21+).

Project layout (overview)

/app
  /src/main/java/com/yourpackage
    /ui           # Compose screens & components
    /viewmodel    # ViewModels exposing StateFlow
    /data
      /local      # Room database, WishDao, WishEntity
    /repository   # Data access abstraction
  /res
AndroidManifest.xml
build.gradle

## Example snippets

## Sample ViewModel

fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish= wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish= wish)
            getAllWishes = wishRepository.getWishes()
        }
    }

## Sample Dao

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

## Sample Repository

class WishRepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

## Contributing
This is a personal learning project (sole developer). Contributions and suggestions are welcome:
Fork the repo
Create a feature branch: feat/your-feature
Commit your changes and open a Pull Request
Suggested improvements:
Search & filtering, categories/tags
Cloud sync (Firebase / REST) for cross-device persistence
Unit & UI tests, CI (GitHub Actions)
Accessibility enhancements and localization

Contact
Built by Rajat Gaidhane — GitHub: RajatGaidhane1









