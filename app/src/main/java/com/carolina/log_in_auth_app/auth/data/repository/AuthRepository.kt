package com.carolina.log_in_auth_app.auth.data.repository

import android.util.Log
import com.carolina.log_in_auth_app.auth.data.datasource.AccessTokenRequest
import com.carolina.log_in_auth_app.auth.data.datasource.AuthLocalDataSource
import com.carolina.log_in_auth_app.auth.data.datasource.AuthRemoteDataSource
import com.carolina.log_in_auth_app.auth.data.mappers.toTokenEntity
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
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
        Log.d("Token get", tokenEntity.toString())
        authLocalDataSource.insertAuthToken(tokenEntity.toTokenEntity())
    }

    companion object {
        const val GRANT_TYPE = "password"
        const val CLIENT_ID = "6GbE8dhoz519l2N_F99StqoOs6Tcmm1rXgda4q__rIw"
        const val CLIENT_SECRET = "_ayfIm7BeUAhx2W1OUqi20fwO3uNxfo1QstyKlFCgHw"
    }
}
