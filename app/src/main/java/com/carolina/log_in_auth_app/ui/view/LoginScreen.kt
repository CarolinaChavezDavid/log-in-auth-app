package com.carolina.log_in_auth_app.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_background),
            contentDescription = "login background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(
                radiusX = 30.dp,
                radiusY = 30.dp,
            ).drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Gray, Color.Black),
                    startY = size.height.div(3),
                    endY = size.height,
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            },
        )
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "logo",
                modifier = Modifier.width(168.dp),
            )

            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = 24.dp,
                    alignment = Alignment.CenterVertically,
                ),
            ) {
                FormInput()
                FormInput()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White, RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = "Log in")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput() {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(56.dp)
            .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(12.dp)),
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.White,
            ),
            modifier = Modifier.fillMaxSize(),
            placeholder = { Text("Email") },
            textStyle = TextStyle(color = Color.White),
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen()
}
