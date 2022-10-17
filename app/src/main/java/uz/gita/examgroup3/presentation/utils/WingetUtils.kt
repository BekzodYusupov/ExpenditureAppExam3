package uz.gita.examgroup3.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.examgroup3.R
import uz.gita.examgroup3.ui.myColorSet
import uz.gita.examgroup3.ui.theme.BackGround
import uz.gita.examgroup3.ui.theme.ExamGroup3Theme
import uz.gita.examgroup3.ui.theme.Grey
import uz.gita.examgroup3.ui.theme.Secondary

@Composable
fun MainButton(
    onEventDispatcher: () -> Unit,
    text: String = "Submit",
    color: Color = MaterialTheme.myColorSet.BrandingColor,
    isActive: Boolean = true
) {
    ExamGroup3Theme {
        Surface {
            Button(
                onClick = {
                    if (isActive) onEventDispatcher.invoke() else {
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .requiredHeight(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = if (isActive) color else Grey)
            ) {
                Text(
                    text = text, fontSize = 16.sp,
                    color = if (isActive) Color.White else MaterialTheme.colorScheme.secondary
                )

            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DateChangeTopBar() {
//    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
    Row(

        modifier = Modifier
            .padding(16.dp)
            .height(48.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(0.dp, Secondary, RoundedCornerShape(24.dp))
            .background(
                BackGround, RoundedCornerShape(24.dp)
            ),

        ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp)
                .size(42.dp)
                .border(
                    1.dp,
                    Secondary,
                    RoundedCornerShape(21.dp)
                )
                .padding(12.dp)
        )
        Text(
            text = "Feb 24, 2022",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.arrow_right),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 4.dp)
                .size(42.dp)
                .border(
                    1.dp,
                    Secondary,
                    RoundedCornerShape(21.dp)
                )
                .padding(12.dp)
        )
    }
}

@Composable
fun CategoryItem(
    image:Int = R.drawable.bank,
    text:String = "Bank"
) {
    Column(
        modifier = Modifier.padding(4.dp)
            .defaultMinSize(minWidth = 90.dp, minHeight = 80.dp)
            .border(1.dp, Grey, RoundedCornerShape(4.dp)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .size(32.dp)
        )
        Text(text = text, fontSize = 12.sp)
    }
}

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun Preview() {
    MainButton(onEventDispatcher = { }, isActive = false)
}