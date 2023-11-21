package com.carolina.log_in_auth_app.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_background),
            contentDescription = "splash background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Gray),
                    startY = size.height.div(5),
                    endY = size.height,
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            },
        )

        Image(
            painter = painterResource(
                id = R.drawable.ic_logo,
            ),
            contentDescription = "logo",
            modifier = Modifier.width(200.dp),
        )
    }
}

@Preview
@Composable
fun previewSplash() {
    SplashScreen()
}
