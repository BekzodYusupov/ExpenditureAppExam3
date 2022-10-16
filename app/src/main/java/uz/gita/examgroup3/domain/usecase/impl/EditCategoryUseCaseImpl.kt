package uz.gita.examgroup3.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.domain.repository.CategoryRepository
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import uz.gita.examgroup3.domain.usecase.EditCategoryUseCase
import javax.inject.Inject

class EditCategoryUseCaseImpl @Inject constructor(
    private val expenditureRepository: ExpenditureRepository,
    private val categoryRepository: CategoryRepository
) : EditCategoryUseCase {
    override fun insertCategory(categoryEntity: CategoryEntity) = categoryRepository.insertCategory(categoryEntity)

    override fun deleteCategory(categoryEntity: CategoryEntity) {
        expenditureRepository.deleteByCategoryId(categoryEntity.id)
        categoryRepository.deleteCategory(categoryEntity)
    }

    override fun getExCategories(): Flow<List<CategoryEntity>> = categoryRepository.getExCategories()

    override fun getIncCategories(): Flow<List<CategoryEntity>> = categoryRepository.getIncCategories()
}