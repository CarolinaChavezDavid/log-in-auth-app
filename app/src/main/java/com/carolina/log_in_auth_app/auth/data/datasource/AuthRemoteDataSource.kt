package com.carolina.log_in_auth_app.auth.data.datasource

import com.carolina.log_in_auth_app.auth.data.api.AuthService
import com.carolina.log_in_auth_app.auth.data.response.AuthResponse
import com.carolina.log_in_auth_app.auth.util.parseResponse
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
