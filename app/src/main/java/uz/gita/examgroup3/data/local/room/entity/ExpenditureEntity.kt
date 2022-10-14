package uz.gita.examgroup3.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExpenditureEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val amount: Double,
    val currency: String,
    val type: Int, //0 = expense and 1 = income
    val categoryId: Long,
    val date: Long

)
