package uz.gita.examgroup3.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.examgroup3.navigation.Directions.SplashDirections
import uz.gita.examgroup3.navigation.Directions.impl.SplashDirectionsImpl

@Module
@InstallIn(SingletonComponent::class)
interface DirectionsModule {
    @Binds
    fun bindsSplashDirection(impl: SplashDirectionsImpl): SplashDirections
}