package uz.gita.examgroup3.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.SplashUseCase
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    private val expenditureRepository: ExpenditureRepository
): SplashUseCase {
    override suspend fun isIntroOpen(state: Boolean): Flow<Boolean> {
        return expenditureRepository.isIntroOpen(state)
    }
}