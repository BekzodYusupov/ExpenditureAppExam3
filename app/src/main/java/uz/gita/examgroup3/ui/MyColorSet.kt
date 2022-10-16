package uz.gita.examgroup3.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class MyColorSet(
    val BrandingColor: Color = Color(0xFF5986F2),
    val Red: Color = Color(0xFFFE7474),
    val Blue: Color = Color(0xFF5982F2),
    val Expense: Color = Color(0xFFFF9A9A),
    val Income: Color = Color(0xFF9AB8FF),
    val Primary: Color = Color(0xFF404040),
    val Secondary: Color = Color(0xFFA6A6A6),
    val Grey: Color = Color(0xFFD9D9D9),
    val BackGround: Color = Color(0xFFF5F5F5),
    val White: Color = Color(0xFFFCFCFC),

    val PrimaryDark: Color = Color(0xFFEAEAEA),
    val SecondaryDark: Color = Color(0xFFBABABF),
    val GreyDark: Color = Color(0xFF898A93),
    val BackgroundDark: Color = Color(0xFF28293D),
    val BlackDark: Color = Color(0xFF28293D),
)

val LocalMyColorSet = compositionLocalOf { MyColorSet() }

val MaterialTheme.myColorSet: MyColorSet
    @Composable
    @ReadOnlyComposable
    get() = LocalMyColorSet.current