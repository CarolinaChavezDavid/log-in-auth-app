package com.carolina.log_in_auth_app.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun setLoginInfo(email: String, password: String){

    }
}
