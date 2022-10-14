package uz.gita.examgroup3.domain.repository

import kotlinx.coroutines.flow.Flow
import java.util.Currency

interface ExpenditureRepository {
    suspend fun isIntroOpen(state: Boolean): Flow<Boolean>

    fun updateCurrency(currency: String)

    fun getCurrency() : Flow<String>

}