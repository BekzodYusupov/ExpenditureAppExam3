package uz.gita.examgroup3.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.dao.CategoryDao
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryDao: CategoryDao) : CategoryRepository {
    //Category
    override fun insertCategory(categoryEntity: CategoryEntity) = categoryDao.insert(categoryEntity)

    override fun updateCategory(categoryEntity: CategoryEntity) = categoryDao.update(categoryEntity)

    override fun deleteCategory(categoryEntity: CategoryEntity) = categoryDao.delete(categoryEntity)

    override fun getCategories(): Flow<List<CategoryEntity>> = categoryDao.getCategories()

    override fun getExCategories(): Flow<List<CategoryEntity>> = categoryDao.getExCategories()

    override fun getIncCategories(): Flow<List<CategoryEntity>> = categoryDao.getIncCategories()

    override fun clearCategoryData() = categoryDao.clearData()
}