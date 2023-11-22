package com.carolina.log_in_auth_app.ui.data

import com.carolina.log_in_auth_app.ui.data.datasource.AuthRemoteDataSource
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authDataSource: AuthRemoteDataSource,
) {

    suspend fun login(email: String, password: String) {
        val loginRequest = AccessTokenRequest(
            grantType = GRANT_TYPE,
            email = email,
            password = password,
            clientId = CLIENT_ID,
            clientSecret = CLIENT_SECRET,
        )

        val tokenEntity = authDataSource.userLogIn(loginRequest)
    }

    companion object {
        const val GRANT_TYPE = ""
        const val CLIENT_ID = ""
        const val CLIENT_SECRET = ""
    }
}
