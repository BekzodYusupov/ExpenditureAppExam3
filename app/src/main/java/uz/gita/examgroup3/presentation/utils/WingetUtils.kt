package uz.gita.examgroup3.presentation.utils

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.gita.examgroup3.ui.myColorSet
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uz.gita.examgroup3.ui.theme.*

@Composable
fun MainButton(
    onEventDispatcher: () -> Unit,
    text: String = "Submit",
    color: Color = MaterialTheme.myColorSet.BrandingColor,
    isActive:Boolean = true
) {
    ExamGroup3Theme {
        Surface {
            Button(
                onClick = { if (isActive) onEventDispatcher.invoke() else {  } },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .requiredHeight(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = if (isActive) color else Grey)
            ) {
                Text(text = text, fontSize = 16.sp,
                color = if (isActive) Color.White else MaterialTheme.colorScheme.secondary)

            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview() {
    MainButton(onEventDispatcher = {  }, isActive = false)
}