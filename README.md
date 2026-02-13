<div align="center">

# Retrofit_Hilt_Jetpack_Compose 🚀

<br>

<!-- Download Button -->
<a href="https://github.com/animeshraj253/RetroFit_Hilt_Jetack_Compose/releases/download/retrofit/app-release.apk">

  <img src="https://img.shields.io/badge/Download-APK-success?style=for-the-badge&logo=android&logoColor=white" alt="Download APK">
</a>

<a href="https://github.com/animeshraj253/RetroFit_Hilt_Jetack_Compose/releases/tag/retrofit">
  <img src="https://img.shields.io/badge/All_Releases-gray?style=for-the-badge&logo=github" alt="All Releases">
</a>


<br>
<br>

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Material 3](https://img.shields.io/badge/Material_3-6200EE?style=for-the-badge&logo=material-design&logoColor=white)](https://m3.material.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)](LICENSE)

</div>

---

## ✨ Features
- **Modern UI:** Built entirely with Jetpack Compose and Material Design 3.
- **Dependency Injection:** Uses Dagger Hilt for modular and testable code.
- **Networking:** Robust API handling with Retrofit and Gson.
- **Architecture:** Implements MVVM (Model-View-ViewModel) with the Repository pattern.
- **State Management:** Reactive UI updates using Kotlin Sealed Classes (Loading, Success, Error).
- **Edge-to-Edge:** Fully supports modern Android display features.

---

## 🛠 Tech Stack & Libraries
- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
- **Dependency Injection:** [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Networking:** [Retrofit 2](https://square.github.io/retrofit/) & [Gson](https://github.com/google/gson)
- **Asynchronous Work:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- **Build System:** Kotlin DSL (Gradle)

---

## 🏗 Architecture
The app follows the **MVVM + Repository** pattern to ensure a clean separation of concerns:

1. **View (Compose):** Observes the `UserUiState` and renders the UI reactively.
2. **ViewModel:** Manages UI state and handles business logic using `viewModelScope`.
3. **Repository:** Acts as a single source of truth for data, abstracting the API layer.
4. **Data (Retrofit):** Defines the network contract and handles JSON parsing.

### Data Flow
`API Interface` ➡️ `Repository` ➡️ `ViewModel` ➡️ `Compose UI`

---

## 📁 Project Structure
```text
com.example.retrofitjc_di
├── api             # Retrofit Interface definitions
├── apiviewmodels   # ViewModels & UI State (Sealed Classes)
├── dataClasses     # Data models / POJOs
├── hilt            # Application class for Hilt initialization
├── modules         # Dagger Hilt Modules (Network & App modules)
├── repo            # Repository implementations
├── ui              # Compose Themes and UI components
└── MainActivity    # Entry point & Main UI Composable
```

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Ladybug or newer.
- JDK 17+.
- Basic knowledge of Kotlin and Jetpack Compose.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/animeshraj253/RetroFit_Hilt_Jetack_Compose
   ```
2. Open the project in Android Studio.
3. Sync the Gradle files.
4. Run the app on an emulator or a physical device.

---

## 📝 API Reference
This project uses the [JSONPlaceholder](https://jsonplaceholder.typicode.com/) API:
- `GET /users`: Fetches a list of users.

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/animeshraj253/RetroFit_Hilt_Jetack_Compose/issues).

---
