package uz.gita.examgroup3.data.local.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface BaseDao<T> {
    @Insert
    fun insert(data: T)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)
}