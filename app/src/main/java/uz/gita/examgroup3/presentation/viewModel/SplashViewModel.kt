package uz.gita.examgroup3.presentation.viewModel

import kotlinx.coroutines.flow.StateFlow
import uz.gita.examgroup3.data.model.SplashScreenIntent

interface SplashViewModel {
    fun onEventDispatcher(intent: SplashScreenIntent)
}