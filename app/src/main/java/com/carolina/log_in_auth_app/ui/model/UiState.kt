package com.carolina.log_in_auth_app.ui.model

sealed class UiState {
    object Loading : UiState()
    data class Success(val recentVersions: List<String>) : UiState()
    data class Error(val message: String) : UiState()
}
