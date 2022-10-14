package uz.gita.examgroup3.presentation.screen

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import uz.gita.examgroup3.R
import uz.gita.examgroup3.data.model.SplashScreenIntent
import uz.gita.examgroup3.presentation.viewModel.SplashViewModel
import uz.gita.examgroup3.presentation.viewModel.impl.SplashViewModelImpl

class SplashScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel:SplashViewModel = getViewModel<SplashViewModelImpl>()
        Splash(viewModel::onEventDispatcher)
    }
}

@Composable
fun Splash(
    onEventDispatcher: (SplashScreenIntent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lotte_splash))
        val logoAnimationState = animateLottieCompositionAsState(composition = composition)
        LottieAnimation(composition = composition, progress = logoAnimationState.progress)
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            onEventDispatcher.invoke(SplashScreenIntent.OpenIntro)
        }
    }
}