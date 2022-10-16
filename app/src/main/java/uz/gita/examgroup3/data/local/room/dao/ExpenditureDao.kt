package uz.gita.examgroup3.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity

@Dao
interface ExpenditureDao : BaseDao<ExpenditureEntity> {
    @Query("SELECT * FROM ExpenditureEntity")
    fun getAll(): Flow<List<ExpenditureEntity>>

    @Query("SELECT * FROM ExpenditureEntity WHERE type = 0")
    fun getExpenses(): Flow<List<ExpenditureEntity>>

    @Query("SELECT * FROM ExpenditureEntity WHERE categoryId = :categoryId")
    fun getByCategoryId(categoryId: Long): Flow<List<ExpenditureEntity>>

    @Query("SELECT * FROM ExpenditureEntity WHERE type = 1")
    fun getIncomes(): Flow<List<CategoryEntity>>

    @Update
    fun updateAll(list: List<ExpenditureEntity>)   // bu pul birligini o'zgartirganda kerak

    @Query("DELETE FROM ExpenditureEntity WHERE categoryId = :categoryId")
    fun deleteByCategoryId(categoryId: Long)    // category o'chirib yuborilganida shu category ga tegishli barcha kirim chiqimlar o'chirib yuboriladi

    @Query("DELETE FROM ExpenditureEntity")
    fun clearData()
}