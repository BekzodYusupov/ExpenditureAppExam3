package uz.gita.examgroup3.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    var imgRes: Int,
    var categoryType: Int //0 = expense and 1 = income
)
