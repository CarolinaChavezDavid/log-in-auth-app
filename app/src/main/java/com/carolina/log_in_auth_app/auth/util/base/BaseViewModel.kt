package com.carolina.log_in_auth_app.auth.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel() {

    fun uiState(): LiveData<T> = uiState
    val uiState: MutableLiveData<T> = MutableLiveData()
}
