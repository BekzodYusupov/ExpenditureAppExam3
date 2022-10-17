package uz.gita.examgroup3.presentation.screen.transaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.examgroup3.R
import uz.gita.examgroup3.presentation.utils.CategoryItem
import uz.gita.examgroup3.presentation.utils.DateChangeTopBar
import uz.gita.examgroup3.presentation.utils.MainButton
import uz.gita.examgroup3.ui.theme.BackGround
import uz.gita.examgroup3.ui.theme.Grey
import uz.gita.examgroup3.ui.theme.Secondary
import uz.gita.examgroup3.ui.theme.White


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainContentExpense() {
    Column(modifier = Modifier.fillMaxSize().background(color = White), verticalArrangement = Arrangement.SpaceBetween) {
        DateChangeTopBar()
        Text(
            text = "Expense",
            modifier = Modifier.padding(start = 16.dp),
            color = Secondary,
            fontSize = 14.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 24.dp)
                .wrapContentHeight()
                .border(1.dp, Secondary, RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_attach_money_24),
                contentDescription = "currency",
                modifier = Modifier
                    .height(56.dp)
                    .width(44.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                    .background(color = BackGround)
                    .padding(start = 6.dp, top = 4.dp, bottom = 4.dp, end = 6.dp)
            )
            Text(
                text = "0.00",
                color = Grey,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp),
                fontSize = 34.sp
            )
        }

        Text(
            text = "Note",
            modifier = Modifier.padding(start = 16.dp),
            color = Secondary,
            fontSize = 14.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 24.dp)
                .wrapContentHeight()
                .border(1.dp, Secondary, RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Please input",
                color = Grey,
                modifier = Modifier
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 16.sp
            )

            Image(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = "currency",
                modifier = Modifier
                    .height(56.dp)
                    .width(44.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                    .padding(start = 6.dp, top = 4.dp, bottom = 4.dp, end = 6.dp)
            )
        }

        Text(
            text = "Category",
            modifier = Modifier.padding(start = 16.dp),
            color = Secondary,
            fontSize = 14.sp
        )


        LazyVerticalGrid(
            columns = GridCells.Adaptive(90.dp),
            contentPadding = PaddingValues(4.dp),
            content = {
                items(15) {
                    CategoryItem()
                }
            })
        MainButton(onEventDispatcher = { /*TODO*/ })
    }
}