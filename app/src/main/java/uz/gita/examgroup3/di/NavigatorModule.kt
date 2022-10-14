package uz.gita.examgroup3.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.examgroup3.navigation.AppNavigator
import uz.gita.examgroup3.navigation.NavigationDispatcher
import uz.gita.examgroup3.navigation.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {
    @Binds
    fun appNavigator(dispatcher: NavigationDispatcher): AppNavigator

    @Binds
    fun navigationHandler(dispatcher: NavigationDispatcher): NavigationHandler
}