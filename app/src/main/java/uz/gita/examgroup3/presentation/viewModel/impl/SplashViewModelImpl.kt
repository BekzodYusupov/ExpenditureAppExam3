package uz.gita.examgroup3.presentation.viewModel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.examgroup3.data.model.SplashScreenIntent
import uz.gita.examgroup3.domain.usecase.SplashUseCase
import uz.gita.examgroup3.navigation.Directions.SplashDirections
import uz.gita.examgroup3.presentation.viewModel.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val directions: SplashDirections,
    private val useCase: SplashUseCase
) : SplashViewModel, ViewModel() {

    override fun onEventDispatcher(intent: SplashScreenIntent) {
        when (intent) {
            SplashScreenIntent.OpenIntro -> {
                viewModelScope.launch {
                    directions.navigateToIntro()
                    useCase.isIntroOpen(true)
                }
            }
            SplashScreenIntent.OpenPin -> {
                viewModelScope.launch { directions.navigateToPin() }
            }
            SplashScreenIntent.OpenTransaction -> {
                viewModelScope.launch { directions.navigateToTransaction() }
            }
        }
    }
}