package com.carolina.log_in_auth_app.ui.data.datasource

import com.carolina.log_in_auth_app.ui.data.AccessTokenRequest
import com.carolina.log_in_auth_app.ui.data.AuthResponse
import com.carolina.log_in_auth_app.ui.data.AuthService
import com.carolina.log_in_auth_app.ui.util.parseResponse
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authService: AuthService,
) {

    suspend fun userLogIn(authDto: AccessTokenRequest): AuthResponse {
        return authService.loginWithEmail(
            authDto.grantType,
            authDto.email,
            authDto.password,
            authDto.clientId,
            authDto.clientSecret,
        ).parseResponse()
    }
}
