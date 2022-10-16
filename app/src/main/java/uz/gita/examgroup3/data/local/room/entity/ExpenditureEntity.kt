package uz.gita.examgroup3.data.local.room.entity

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExpenditureEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var amount: Double,
    var notes: String,
    var type: Int, //0 = expense and 1 = income
    var categoryId: Long,
    var date: Long
)
