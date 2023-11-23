package com.carolina.log_in_auth_app.view.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.carolina.log_in_auth_app.R
import com.carolina.log_in_auth_app.auth.model.LoginViewModel
import com.carolina.log_in_auth_app.theme.ColorTextHint
import com.carolina.log_in_auth_app.theme.smallTextBoldStyle
import com.carolina.log_in_auth_app.theme.smallTextStyle

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
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
            LoginHeader()
            LoginForm(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputEmail(viewModel: LoginViewModel) {
    var text by remember { mutableStateOf("") }
    val isVisible by remember {
        derivedStateOf {
            text.isNotEmpty()
        }
    }
    viewModel.updateEmail(text)

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
                placeholderColor = ColorTextHint,
            ),
            modifier = Modifier.fillMaxSize(),
            textStyle = smallTextStyle.copy(color = Color.White),
            placeholder = { Text(text = "Email", style = smallTextStyle) },
            trailingIcon = {
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    IconButton(
                        onClick = { text = "" },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_clear_24),
                            contentDescription = "Clear",
                        )
                    }
                }
            },

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputPassword(viewModel: LoginViewModel) {
    var text by remember { mutableStateOf("") }
    val isVisible by remember {
        derivedStateOf {
            text.isNotEmpty()
        }
    }

    viewModel.updatePassword(text)

    Box(
        modifier = Modifier.fillMaxWidth()
            .height(56.dp)
            .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(12.dp)),
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = ColorTextHint,
                cursorColor = Color.White,
            ),
            placeholder = { Text(text = "Password", style = smallTextStyle) },
            textStyle = smallTextStyle.copy(color = Color.White),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    IconButton(
                        onClick = { text = "" },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_clear_24),
                            contentDescription = "Clear",
                        )
                    }
                }
            },
        )
        if (!isVisible) {
            Text(
                text = "forgot?",
                style = smallTextStyle,
                modifier = Modifier.align(Alignment.CenterEnd).padding(16.dp),
            )
        }
    }
}

@Composable
fun LoginHeader() {
    Box(
        modifier = Modifier.fillMaxWidth().padding(vertical = 150.dp),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier.width(168.dp),
        )
    }
}

@Composable
fun LoginForm(viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        FormInputEmail(viewModel)
        FormInputPassword(viewModel)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.White, RoundedCornerShape(12.dp))
                .clickable { viewModel.performLogin() },
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Log in", style = smallTextBoldStyle)
        }
    }
}
