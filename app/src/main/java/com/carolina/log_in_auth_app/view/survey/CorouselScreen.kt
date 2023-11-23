package com.carolina.log_in_auth_app.view.survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R
import com.carolina.log_in_auth_app.theme.bigHeaderTextStyle
import com.carolina.log_in_auth_app.theme.mediumHeaderTextStyle
import com.carolina.log_in_auth_app.view.ScreensBackground

@Composable
fun CarouselScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center,
    ) {
        ScreensBackground(R.drawable.ic_home_background)
        CarouselHeader()
    }
}

@Composable
fun CarouselHeader() {
    Row(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter), verticalAlignment = ) {
        Column {
            Text(text = "WEDNESDAY, NOVEMBER22", style = mediumHeaderTextStyle)
            Text(text = "TODAY", style = bigHeaderTextStyle)
        }
        Image(painter = painterResource(id = R.drawable.ic_home_background), contentDescription = "user profile")
    }
}

@Composable
fun CarouselFooter() {
    Row() {
        Column {
            Text(text = )
            Text(text = )
        }
        Image(painter = , contentDescription = "suvey Arrow")
    }
}
