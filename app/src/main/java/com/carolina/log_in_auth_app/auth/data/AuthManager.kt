package com.carolina.log_in_auth_app.auth.data

import coil.request.Disposable
import com.carolina.log_in_auth_app.auth.data.datasource.AuthLocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
) {

    private var _accessToken: String = ""
    val accessToken get() = _accessToken


}
