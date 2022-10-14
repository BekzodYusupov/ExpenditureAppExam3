package uz.gita.examgroup3.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.examgroup3.data.local.room.dao.CategoryDao
import uz.gita.examgroup3.data.local.room.dao.ExpenditureDao
import uz.gita.examgroup3.data.local.room.entity.CategoryEntity
import uz.gita.examgroup3.data.local.room.entity.ExpenditureEntity

@Database(entities = [ExpenditureEntity::class, CategoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun categoryDao():CategoryDao
    abstract fun expenditureDao():ExpenditureDao
}