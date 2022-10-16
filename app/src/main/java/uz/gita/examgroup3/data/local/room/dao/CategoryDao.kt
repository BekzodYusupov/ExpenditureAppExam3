package uz.gita.examgroup3.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity

@Dao
interface CategoryDao : BaseDao<CategoryEntity> {

    @Query("SELECT * FROM CategoryEntity")
    fun getCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM CategoryEntity WHERE categoryType = 0")
    fun getExCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM CategoryEntity WHERE categoryType = 1")
    fun getIncCategories(): Flow<List<CategoryEntity>>

    @Query("DELETE FROM CategoryEntity")
    fun clearData()
}