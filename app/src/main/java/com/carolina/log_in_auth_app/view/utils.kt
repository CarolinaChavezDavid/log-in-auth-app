package com.carolina.log_in_auth_app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ScreensBackground(resourceId: Int) {
    Image(
        painter = painterResource(id = resourceId),
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
}
