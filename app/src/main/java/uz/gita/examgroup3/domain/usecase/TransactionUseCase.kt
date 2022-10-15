package uz.gita.examgroup3.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity

interface TransactionUseCase {
    fun saveTransaction(expenditureEntity: ExpenditureEntity)

    fun getExCategories(): Flow<List<CategoryEntity>>

    fun getIncCategories(): Flow<List<CategoryEntity>>
}