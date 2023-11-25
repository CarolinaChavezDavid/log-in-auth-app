package com.carolina.log_in_auth_app.survey.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R
import com.carolina.log_in_auth_app.theme.ColorTextHint
import com.carolina.log_in_auth_app.theme.bigHeaderTextStyle
import com.carolina.log_in_auth_app.theme.smallTextBoldStyle
import com.carolina.log_in_auth_app.theme.smallTextStyle
import com.carolina.log_in_auth_app.app.view.ScreensBackground

@Composable
fun CarouselDetailScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        // ScreensBackground(R.drawable.ic_home_background)
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            CarouselDetailHeader()
            CarouselDetailFooter()
        }
    }
}

@Composable
fun CarouselDetailHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_navigate_before_24),
            contentDescription = "tap back",
            modifier = Modifier.width(36.dp).height(36.dp),
            contentScale = ContentScale.Fit,
        )
        Text(text = "Working from home check-in", style = bigHeaderTextStyle)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "We would like to know how you feel  about our work from home",
            style = smallTextStyle.copy(color = ColorTextHint),
        )
    }
}

@Composable
fun CarouselDetailFooter() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Box(
            modifier = Modifier.height(56.dp)
                .width(140.dp)
                .background(Color.White, RoundedCornerShape(12.dp)),
        ) {
            Text(
                text = "Start Survey",
                style = smallTextBoldStyle,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Preview
@Composable
fun CarouselDetailPreview() {
    CarouselDetailScreen()
}
