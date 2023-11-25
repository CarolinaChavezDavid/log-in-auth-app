package com.carolina.log_in_auth_app.survey.view

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R
import com.carolina.log_in_auth_app.theme.ColorTextHint
import com.carolina.log_in_auth_app.theme.bigHeaderTextStyle
import com.carolina.log_in_auth_app.theme.smallTextStyle
import com.carolina.log_in_auth_app.app.view.ScreensBackground

@Composable
fun SurveyQuestionScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        // ScreensBackground(R.drawable.ic_home_background)
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            SurveyHeader()
            SurveyFooter()
        }
    }
}

@Composable
fun SurveyHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_clear_24),
            contentDescription = "tap back",
            modifier = Modifier.width(36.dp).height(36.dp),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "1/5",
            style = smallTextStyle.copy(color = ColorTextHint),
        )
        Text(text = "How fullfilled did you feel in this WFH period?", style = bigHeaderTextStyle)
    }
}

@Composable
fun SurveyFooter() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Image(
            modifier = Modifier.width(56.dp).height(56.dp).weight(1f),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.baseline_arrow_circle_right_24),
            contentDescription = "survey Arrow",
        )
    }
}

@Preview
@Composable
fun SurveyPreview() {
    SurveyQuestionScreen()
}
