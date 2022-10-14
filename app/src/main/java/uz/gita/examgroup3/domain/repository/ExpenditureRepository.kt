package uz.gita.examgroup3.domain.repository

import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity

interface ExpenditureRepository {
    suspend fun isIntroOpen(state: Boolean): Flow<Boolean>

    fun updateCurrency(currency: String)

    fun getCurrency(): Flow<String>


    //Expenditure
    fun insertExpenditure(expenditureEntity: ExpenditureEntity)

    fun updateExpenditure(expenditureEntity: ExpenditureEntity)

    fun deleteExpenditure(expenditureEntity: ExpenditureEntity)

    fun getAllExpenditure(): Flow<List<ExpenditureEntity>>

    fun getExpenses(): Flow<List<ExpenditureEntity>>

    fun getIncomes(): Flow<List<CategoryEntity>>

    fun updateAllExpenditure(list: ExpenditureEntity)

    fun deleteByCategoryId(categoryId: Long)

    fun clearExpenditureData()
}