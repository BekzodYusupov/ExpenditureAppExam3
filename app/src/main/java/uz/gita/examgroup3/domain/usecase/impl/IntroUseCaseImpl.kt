package uz.gita.examgroup3.domain.usecase.impl

import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.IntroUseCase
import javax.inject.Inject

class IntroUseCaseImpl @Inject constructor(
    private val expenditureRepository: ExpenditureRepository
): IntroUseCase