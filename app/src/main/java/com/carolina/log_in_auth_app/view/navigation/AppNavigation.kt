package com.carolina.log_in_auth_app.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carolina.log_in_auth_app.auth.model.LoginViewModel
import com.carolina.log_in_auth_app.view.login.LoginScreen
import com.carolina.log_in_auth_app.view.splash.SplashScreen

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
            LoginScreen(viewModel)
        }
    }
}
