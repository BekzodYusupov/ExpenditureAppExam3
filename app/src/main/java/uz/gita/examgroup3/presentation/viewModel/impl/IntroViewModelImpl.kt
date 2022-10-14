package uz.gita.examgroup3.presentation.viewModel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examgroup3.domain.usecase.IntroUseCase
import uz.gita.examgroup3.presentation.viewModel.IntroViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModelImpl @Inject constructor(
    private val introUseCase: IntroUseCase
): IntroViewModel, ViewModel()