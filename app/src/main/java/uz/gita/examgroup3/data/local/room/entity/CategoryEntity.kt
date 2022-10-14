package uz.gita.examgroup3.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val imgRes: Int,
    val categoryType: Int //0 = expense and 1 = income
)
