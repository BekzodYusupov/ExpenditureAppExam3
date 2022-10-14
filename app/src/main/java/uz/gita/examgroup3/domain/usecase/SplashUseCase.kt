package uz.gita.examgroup3.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SplashUseCase {
    suspend fun isIntroOpen(state: Boolean): Flow<Boolean>
}