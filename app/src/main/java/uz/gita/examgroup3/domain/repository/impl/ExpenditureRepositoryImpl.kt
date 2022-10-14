package uz.gita.examgroup3.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.examgroup3.data.local.room.dao.CategoryDao
import uz.gita.examgroup3.data.local.shared_pref.ShP
import uz.gita.examgroup3.data.local.room.dao.ExpenditureDao
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity
import uz.gita.examgroup3.domain.repository.ExpenditureRepository
import javax.inject.Inject

class ExpenditureRepositoryImpl @Inject constructor(
    private val expenditureDao: ExpenditureDao,
    private val categoryDao: CategoryDao,
    private val mShP: ShP
) : ExpenditureRepository {

    override suspend fun isIntroOpen(state: Boolean): Flow<Boolean> = flow {
        if (!mShP.isInit) {
            emit(mShP.isInit)
            mShP.isInit = state
        }
    }.flowOn(Dispatchers.IO)

    override fun updateCurrency(currency: String) {
        mShP.currency = currency
    }

    override fun getCurrency(): Flow<String> = flow {
        emit(mShP.currency)
    }.flowOn(Dispatchers.IO)

    //Category
    override fun insertCategory(categoryEntity: CategoryEntity) = categoryDao.insert(categoryEntity)

    override fun updateCategory(categoryEntity: CategoryEntity) = categoryDao.update(categoryEntity)

    override fun deleteCategory(categoryEntity: CategoryEntity) = categoryDao.delete(categoryEntity)

    override fun getCategories(): Flow<List<CategoryEntity>> = categoryDao.getCategories()

    override fun getExCategories(): Flow<List<CategoryEntity>> = categoryDao.getExCategories()

    override fun getIncCategories(): Flow<List<CategoryEntity>> = categoryDao.getIncCategories()

    override fun clearCategoryData() = categoryDao.clearData()


    //Expenditure
    override fun insertExpenditure(expenditureEntity: ExpenditureEntity) = expenditureDao.insert(expenditureEntity)

    override fun updateExpenditure(expenditureEntity: ExpenditureEntity) = expenditureDao.update(expenditureEntity)

    override fun deleteExpenditure(expenditureEntity: ExpenditureEntity) = expenditureDao.delete(expenditureEntity)

    override fun getAllExpenditure(): Flow<List<ExpenditureEntity>> = expenditureDao.getAll()

    override fun getExpenses(): Flow<List<ExpenditureEntity>> = expenditureDao.getExpenses()

    override fun getIncomes(): Flow<List<CategoryEntity>> = expenditureDao.getIncomes()

    override fun updateAllExpenditure(list: ExpenditureEntity) = expenditureDao.updateAll(list)

    override fun deleteByCategoryId(categoryId: Long) = expenditureDao.deleteByCategoryId(categoryId)

    override fun clearExpenditureData() = expenditureDao.clearData()

}