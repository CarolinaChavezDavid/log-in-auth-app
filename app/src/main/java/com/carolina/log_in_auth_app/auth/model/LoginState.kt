package com.carolina.log_in_auth_app.auth.model

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val recentVersions: List<String>) : LoginState()
    data class Error(val message: String) : LoginState()
}
