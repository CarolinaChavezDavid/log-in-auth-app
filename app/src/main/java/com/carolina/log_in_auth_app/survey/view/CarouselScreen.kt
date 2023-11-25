package com.carolina.log_in_auth_app.survey.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.carolina.log_in_auth_app.survey.data.model.SurveyDataModel
import com.carolina.log_in_auth_app.survey.model.SurveyListViewModel
import com.carolina.log_in_auth_app.survey.model.SurveyState

@Composable
fun CarouselScreen(
    viewModel: SurveyListViewModel = hiltViewModel(),
) {
    viewModel.fetchSurveyList()
    val items by viewModel.uiState.observeAsState()

    if (items is SurveyState.Success) {
        val survey = (viewModel.uiState as SurveyState.Success).surveys
        CarouselScreen(items = survey, page = survey.size)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun CarouselScreen(items: List<SurveyDataModel>, page: Int) {
    val pagerState = rememberPagerState(pageCount = { page })

    HorizontalPager(state = pagerState) { index ->
        Box(modifier = Modifier.fillMaxSize()) {
            CarouselItemScreen(items[index])
        }
    }

    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxSize()
            .padding(bottom = 200.dp, start = 24.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp),
            )
        }
    }
}

@Preview
@Composable
fun previewCarousel() {
    CarouselScreen()
}
