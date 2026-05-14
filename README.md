# ShopTrack 🛒

> An offline-first Android shopping list app built with Kotlin, Jetpack Compose, and MVVM architecture.

<img width="1440" height="900" alt="Screenshot 2026-05-15 at 12 03 53 AM" src="https://github.com/user-attachments/assets/3580f986-e091-4fa7-a026-12cac7c9efab" />
<img width="1440" height="900" alt="Screenshot 2026-05-15 at 12 03 58 AM" src="https://github.com/user-attachments/assets/d8465c15-e83c-4af0-9dfe-242b650df156" />
<img width="1440" height="900" alt="Screenshot 2026-05-15 at 12 04 26 AM" src="https://github.com/user-attachments/assets/92ccdd9d-640e-4eb6-a726-0f0caf533570" />


---

## Overview

ShopTrack is a clean, production-structured Android application that lets users manage a personal shopping list entirely offline. Built as a solo project to demonstrate modern Android development patterns — from reactive state management with Kotlin Flow to local persistence with Room — the codebase is intentionally structured for clarity and scalability.

---

## Features

- **Add items** — Create new shopping list entries with a name and quantity
- **Edit items** — Update existing entries inline
- **Delete items** — Remove items from the list
- **Reactive UI** — Instant screen updates powered by `StateFlow` and Kotlin `Flow`
- **Offline-first** — All data is stored locally via Room; no internet connection required
- **Smooth navigation** — Screen transitions handled by Jetpack Navigation Compose

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | MVVM + Repository Pattern |
| State Management | Kotlin StateFlow / Flow |
| Local Database | Room (Entity, DAO) |
| Navigation | Jetpack Navigation Compose |
| Concurrency | Kotlin Coroutines (`viewModelScope`, `Dispatchers.IO`) |
| Build System | Gradle (Kotlin DSL) |
| Version Control | Git + GitHub |

---

## Architecture

The project follows **MVVM (Model-View-ViewModel)** with a **Repository pattern** for a clean separation of concerns.

```
app/src/main/java/com/rajat/myshopcart/
│
├── ui/                  # Jetpack Compose screens and UI components
├── viewmodel/           # ViewModels exposing StateFlow to the UI
├── data/
│   └── local/           # Room database, Item entity, ItemDao
└── repository/          # Repository abstracting data access from ViewModel
```

### Data Flow

```
UI (Compose) ──► ViewModel ──► Repository ──► Room DAO ──► SQLite
     ▲                │
     └── StateFlow ◄──┘
```

The `ViewModel` exposes a `StateFlow<List<Item>>` collected from Room via `Flow`, ensuring the UI reacts automatically to any data changes.

---

## Key Code

### ViewModel
```kotlin
fun addItem(item: Item) {
    viewModelScope.launch(Dispatchers.IO) {
        itemRepository.addAWish(wish = item)
    }
}

fun deleteItem(item: Item) {
    viewModelScope.launch(Dispatchers.IO) {
        itemRepository.deleteAWish(wish = item)
        getAllItems = itemRepository.getWishes()
    }
}
```

### Room DAO
```kotlin
@Dao
abstract class ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(itemEntity: Item)

    @Query("SELECT * FROM `item-table`")
    abstract fun getAllWishes(): Flow<List<Item>>

    @Update
    abstract suspend fun updateAWish(itemEntity: Item)
}
```

### Repository
```kotlin
class WishRepository(private val itemDao: ItemDao) {

    suspend fun addAWish(item: Item) { itemDao.addAWish(item) }

    fun getWishes(): Flow<List<Item>> = itemDao.getAllWishes()

    suspend fun updateAWish(item: Item) { itemDao.updateAWish(item) }

    suspend fun deleteAWish(item: Item) { itemDao.deleteAWish(item) }
}
```

---

## Getting Started

### Prerequisites
- Android Studio (Arctic Fox or later)
- Android device or emulator running **API 21+**
- JDK 11+

### Setup
```bash
git clone https://github.com/RajatGaidhane1/ShopTrack.git
cd ShopTrack
```

1. Open the project in **Android Studio**
2. Let Gradle sync and download all dependencies
3. Run the app on an emulator or physical device

---

## Screenshots

> _Add screenshots here — suggested: Home list screen, Add item screen, Edit item screen_

| Home Screen | Add Item | Edit Item |
|---|---|---|
| `screenshot_home.png` | `screenshot_add.png` | `screenshot_edit.png` |

---

## Roadmap

Potential improvements for future versions:

- [ ] Search and filter items by name
- [ ] Item categories and tags
- [ ] Cloud sync via Firebase Firestore
- [ ] Dependency injection with Hilt
- [ ] Unit tests with JUnit and Mockito
- [ ] UI tests with Compose Testing
- [ ] CI pipeline with GitHub Actions

---

## Author

**Rajat Gaidhane**
- GitHub: [@RajatGaidhane1](https://github.com/RajatGaidhane1)
- LinkedIn: [linkedin.com/in/rajatgaidhane](https://linkedin.com/in/rajatgaidhane)

---

## License

This project is open source and available under the [MIT License](LICENSE).
