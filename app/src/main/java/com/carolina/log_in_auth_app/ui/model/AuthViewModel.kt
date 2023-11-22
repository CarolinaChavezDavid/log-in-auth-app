package com.carolina.log_in_auth_app.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolina.log_in_auth_app.ui.usecase.LoginUseCase
import javax.inject.Inject

class AuthViewModel @Inject() : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val loginUseCase = LoginUseCase()

    fun performLogin(){

    }
}
