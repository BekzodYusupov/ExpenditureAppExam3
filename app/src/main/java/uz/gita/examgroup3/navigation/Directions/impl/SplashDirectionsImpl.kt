package uz.gita.examgroup3.navigation.Directions.impl

import uz.gita.examgroup3.navigation.AppNavigator
import uz.gita.examgroup3.navigation.Directions.SplashDirections
import uz.gita.examgroup3.presentation.screen.IntroScreen
import javax.inject.Inject

class SplashDirectionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
): SplashDirections {

    override suspend fun navigateToIntro() {
        appNavigator.navigateTo(IntroScreen())
    }

    override suspend fun navigateToPin() {
        appNavigator
    }

    override suspend fun navigateToTransaction() {
        appNavigator
    }
}