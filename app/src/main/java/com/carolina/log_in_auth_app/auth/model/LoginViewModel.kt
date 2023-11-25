package com.carolina.log_in_auth_app.auth.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.carolina.log_in_auth_app.auth.usecase.LoginUseCase
import com.carolina.log_in_auth_app.auth.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginState>() {

    var email by mutableStateOf("")
    var isLogged by mutableStateOf(false)

    fun updateEmail(input: String) {
        email = input
    }

    var password by mutableStateOf("")

    fun updatePassword(input: String) {
        password = input
        Log.d("Password", "this is the password $input")
    }

    fun performLogin() {
        uiState.value = LoginState.Loading
        viewModelScope.launch {
            try {
                loginUseCase.execute(email, password)
                isLogged = true
            } catch (e: Throwable) {
                isLogged = false
            }
        }
    }
}
