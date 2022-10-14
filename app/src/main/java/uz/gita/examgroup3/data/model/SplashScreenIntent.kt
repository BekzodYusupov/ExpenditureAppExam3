package uz.gita.examgroup3.data.model

import android.content.Intent

sealed interface SplashScreenIntent {
    object OpenIntro : SplashScreenIntent
    object OpenPin :SplashScreenIntent
    object OpenTransaction :SplashScreenIntent
}