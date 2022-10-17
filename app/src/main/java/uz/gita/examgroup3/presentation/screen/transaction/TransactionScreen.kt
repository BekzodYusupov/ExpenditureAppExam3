package uz.gita.examgroup3.presentation.screen.transaction

import android.hardware.lights.Light
import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import uz.gita.examgroup3.R
import uz.gita.examgroup3.presentation.utils.CategoryItem
import uz.gita.examgroup3.presentation.utils.DateChangeTopBar
import uz.gita.examgroup3.presentation.utils.MainButton
import uz.gita.examgroup3.ui.theme.*

class TransactionScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        TabScreen()
    }
}

@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabScreen() {
    val pagerState = rememberPagerState(2)

    Column(modifier = Modifier.background(color = BackGround)) {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when(page) {
            0-> MainContentExpense()
            1-> MainContentInCome()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("Expanse", "Income")
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = White,
        modifier = Modifier.background(Color.White)
    ) {

        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) BrandingColor
                        else Grey
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}
