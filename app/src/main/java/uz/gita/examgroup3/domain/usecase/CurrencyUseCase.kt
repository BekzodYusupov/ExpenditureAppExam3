package uz.gita.examgroup3.domain.usecase

import kotlinx.coroutines.flow.Flow

interface CurrencyUseCase {
    fun updateCurrency(newCurrency: String): Boolean

    fun getCurrency(): Flow<String>
}