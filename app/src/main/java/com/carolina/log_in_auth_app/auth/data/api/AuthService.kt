package com.carolina.log_in_auth_app.auth.data.api

import com.carolina.log_in_auth_app.auth.data.response.AuthResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("/api/v1/oauth/token")
    suspend fun loginWithEmail(
        @Query("grant_type") grantType: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
    ): Response<AuthResponse>
}
