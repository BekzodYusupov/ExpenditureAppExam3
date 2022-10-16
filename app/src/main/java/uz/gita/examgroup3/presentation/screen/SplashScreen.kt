package uz.gita.examgroup3.presentation.screen

import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.airbnb.lottie.compose.*
import uz.gita.examgroup3.R
import uz.gita.examgroup3.data.model.SplashScreenIntent
import uz.gita.examgroup3.presentation.viewModel.SplashViewModel
import uz.gita.examgroup3.presentation.viewModel.impl.SplashViewModelImpl

class SplashScreen : AndroidScreen() {
    @Composable
    override fun Content() {
//        val viewModel:SplashViewModel = getViewModel<SplashViewModelImpl>()
        Splash()
    }
}

@Composable
fun Splash(
//    onEventDispatcher: (SplashScreenIntent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(100.dp)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_splash))
        val logoAnimationState = animateLottieCompositionAsState(composition = composition)
        LottieAnimation(composition = composition, progress = logoAnimationState.progress)
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            logoAnimationState.progress
//            onEventDispatcher.invoke(SplashScreenIntent.OpenIntro)
            //locala usage oops :)
            val navigator = LocalNavigator.currentOrThrow
            navigator.push(IntroScreen())
        }
    }
}