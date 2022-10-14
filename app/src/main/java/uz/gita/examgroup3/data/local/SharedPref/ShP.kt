package uz.gita.examgroup3.data.local.SharedPref

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShP @Inject constructor(@ApplicationContext private val context: Context) {

    private val shP: SharedPreferences =
        context.getSharedPreferences("EXPENDITURE", Context.MODE_PRIVATE)

    var isInit: Boolean
        get() = shP.getBoolean("isInit", false)
        set(state) {
            shP.edit().putBoolean("EXPENDITURE", state).apply()
        }
}