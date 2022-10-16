package uz.gita.examgroup3.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.gita.examgroup3.R
import uz.gita.examgroup3.data.model.IntroData
import uz.gita.examgroup3.presentation.utils.MainButton
import uz.gita.examgroup3.ui.myColorSet

class IntroScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        TabLayout()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val coroutineScope = rememberCoroutineScope()
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false//removes system bar
    val items: ArrayList<IntroData> = arrayListOf(
        IntroData(R.drawable.intro_light_1, R.string.intro_title_1, R.string.intro_content_1),
        IntroData(R.drawable.intro_light_2, R.string.intro_title_2, R.string.intro_content_2),
        IntroData(R.drawable.intro_light_3, R.string.intro_title_3, R.string.intro_content_3)
    )

    val pagerState =
        rememberPagerState(pageCount = items.size, initialOffscreenLimit = 2, initialPage = 0)


    OnBoardingPager(
        items = items,
        pagerState = pagerState,
        modifier = Modifier.fillMaxWidth(),
        coroutineScope
    )

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    items: List<IntroData>,
    pagerState: PagerState,
    modifier: Modifier,
    coroutineScope: CoroutineScope,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val navigator = LocalNavigator.currentOrThrow

            Text(text = "${pagerState.currentPage + 1}/${items.size}")
            if (pagerState.currentPage + 1 < items.size) {
                OutlinedButton(
                    onClick = {
                        navigator.push(TransactionScreen())
                    },
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(text = "Skip")
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(500.dp)
        ) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(id = items[page].image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = stringResource(items[page].title),//to get string resource
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(items[page].desc),//to get string resource
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = MaterialTheme.myColorSet.Secondary
                        )
                    }

                }
            }
        }
        if (pagerState.currentPage + 1 < items.size) {
            Button(
                onClick = { coroutineScope.launch { pagerState.scrollToPage(pagerState.currentPage + 1) } },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .requiredHeight(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.myColorSet.BrandingColor)
            ) {
                Text(
                    text = "Continue", fontSize = 16.sp,
                    color = Color.White
                )

            }
        } else MainButton(
            onEventDispatcher = { /*coroutineScope.launch { pagerState.currentPage + 1 }---ain't working don't know why*/ },
            text = "Get Started"
        )
    }
}

