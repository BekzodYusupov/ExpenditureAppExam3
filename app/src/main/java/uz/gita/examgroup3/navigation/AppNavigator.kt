package uz.gita.examgroup3.navigation

import cafe.adriel.voyager.androidx.AndroidScreen

interface AppNavigator {
    suspend fun back()
    suspend fun backAll()
    suspend fun backToRoot()
    suspend fun navigateTo(screen: AndroidScreen)
}