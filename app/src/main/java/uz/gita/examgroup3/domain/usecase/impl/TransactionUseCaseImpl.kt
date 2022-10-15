package uz.gita.examgroup3.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity
import uz.gita.examgroup3.domain.repository.CategoryRepository
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.TransactionUseCase
import javax.inject.Inject

class TransactionUseCaseImpl @Inject constructor(
    private val expenditureRepository: ExpenditureRepository,
    private val categoryRepository: CategoryRepository
) :
    TransactionUseCase {
    override fun saveTransaction(expenditureEntity: ExpenditureEntity) =
        expenditureRepository.insertExpenditure(expenditureEntity)

    override fun getExCategories(): Flow<List<CategoryEntity>> = categoryRepository.getExCategories()

    override fun getIncCategories(): Flow<List<CategoryEntity>> = categoryRepository.getIncCategories()
}