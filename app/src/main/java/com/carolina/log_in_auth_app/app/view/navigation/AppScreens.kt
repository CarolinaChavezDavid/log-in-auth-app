package com.carolina.log_in_auth_app.app.view.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash_screen")
    object LoginScreen : AppScreens("login_screen")

    object CarouselScreen : AppScreens("carousel_screen")
}
