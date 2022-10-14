package uz.gita.examgroup3.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity

interface CategoryRepository {
    //Category
    fun insertCategory(categoryEntity: CategoryEntity)

    fun updateCategory(categoryEntity: CategoryEntity)

    fun deleteCategory(categoryEntity: CategoryEntity)

    fun getCategories(): Flow<List<CategoryEntity>>

    fun getExCategories(): Flow<List<CategoryEntity>>

    fun getIncCategories(): Flow<List<CategoryEntity>>

    fun clearCategoryData()
}