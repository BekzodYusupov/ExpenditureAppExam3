package uz.gita.examgroup3.domain.usecase

import kotlinx.coroutines.flow.Flow

interface CurrencyUseCase {
    fun updateCurrency(currency: String)

    fun getCurrency(): Flow<String>
}