package uz.gita.examgroup3.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity

interface EditCategoryUseCase {
    fun insertCategory(categoryEntity: CategoryEntity)

    fun deleteCategory(categoryEntity: CategoryEntity)

    fun getExCategories(): Flow<List<CategoryEntity>>

    fun getIncCategories(): Flow<List<CategoryEntity>>
}