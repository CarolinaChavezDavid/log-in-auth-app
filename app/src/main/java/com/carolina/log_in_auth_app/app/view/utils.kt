package com.carolina.log_in_auth_app.app.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ScreensBackground(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "survey background",
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
}
