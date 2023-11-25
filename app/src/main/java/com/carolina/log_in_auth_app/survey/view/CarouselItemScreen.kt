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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R
import com.carolina.log_in_auth_app.app.util.DateUtil
import com.carolina.log_in_auth_app.app.view.ScreensBackground
import com.carolina.log_in_auth_app.survey.data.model.SurveyAttributesModel
import com.carolina.log_in_auth_app.survey.data.model.SurveyDataModel
import com.carolina.log_in_auth_app.theme.ColorTextHint
import com.carolina.log_in_auth_app.theme.bigHeaderTextStyle
import com.carolina.log_in_auth_app.theme.mediumHeaderTextStyle
import com.carolina.log_in_auth_app.theme.smallTextStyle

@Composable
fun CarouselItemScreen(item: SurveyDataModel) {
    val survey = item.attributes
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        ScreensBackground(survey.coverImageUrl)
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            CarouselHeader()
            CarouselFooter(survey)
        }
    }
}

@Composable
fun CarouselHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(text = DateUtil.getTodayDate().toString(), style = mediumHeaderTextStyle)
            Text(text = "TODAY", style = bigHeaderTextStyle)
        }
        Image(painter = painterResource(id = R.drawable.ic_profile_icon), contentDescription = "user profile")
    }
}

@Composable
fun CarouselFooter(detail: SurveyAttributesModel) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(3f)) {
            Text(text = detail.title, style = bigHeaderTextStyle)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = detail.description,
                style = smallTextStyle.copy(color = ColorTextHint),
            )
        }
        Image(
            modifier = Modifier.width(56.dp).height(56.dp).weight(1f).align(Alignment.Bottom),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.baseline_arrow_circle_right_24),
            contentDescription = "survey Arrow",
        )
    }
}
