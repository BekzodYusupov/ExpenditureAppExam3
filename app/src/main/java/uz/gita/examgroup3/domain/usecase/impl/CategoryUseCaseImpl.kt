package uz.gita.examgroup3.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.domain.repository.CategoryRepository
import uz.gita.examgroup3.domain.usecase.CategoryUseCase
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : CategoryUseCase {
    override fun getExCategories(): Flow<List<CategoryEntity>> = categoryRepository.getExCategories()

    override fun getIncCategories(): Flow<List<CategoryEntity>> = categoryRepository.getIncCategories()
}