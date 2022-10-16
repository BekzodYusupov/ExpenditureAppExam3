package uz.gita.examgroup3.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CBUData(
    @SerializedName("Ccy")
    val ccy: String,

    @SerializedName("CcyNm_EN")
    val ccyNm_EN: String,

    @SerializedName("CcyNm_RU")
    val ccyNm_RU: String,

    @SerializedName("CcyNm_UZ")
    val ccyNm_UZ: String,

    @SerializedName("CcyNm_UZC")
    val ccyNm_UZC: String,

    @SerializedName("Code")
    val code: String,

    @SerializedName("Date")
    val date: String,

    @SerializedName("Diff")
    val diff: String,

    @SerializedName("Nominal")
    val nominal: String,

    @SerializedName("Rate")
    val rate: String,

    val id: Int
)