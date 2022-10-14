package uz.gita.examgroup3.domain.repository

import kotlinx.coroutines.flow.Flow

interface CurrencyRepo {
    fun updateCurrency(currency: String)

    fun getCurrency(): Flow<String>
}