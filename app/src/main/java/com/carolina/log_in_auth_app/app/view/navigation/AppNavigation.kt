package com.carolina.log_in_auth_app.app.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carolina.log_in_auth_app.auth.model.LoginViewModel
import com.carolina.log_in_auth_app.auth.view.LoginScreen
import com.carolina.log_in_auth_app.survey.view.CarouselScreen
import com.carolina.log_in_auth_app.app.view.splash.SplashScreen

@Composable
fun AppNavigation(viewModel: LoginViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route,
    ) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(viewModel, navController)
        }

        composable(AppScreens.CarouselScreen.route) {
            CarouselScreen()
        }
    }
}
