package com.carolina.log_in_auth_app.ui.data

import com.squareup.moshi.Json

data class AuthResponse(
    @Json(name = "data") val data: LoginResponseData?,
)

data class LoginResponseData(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "attributes") val attributes: LoginResponseAttributes?,
)

data class LoginResponseAttributes(
    @Json(name = "access_token") val accessToken: String?,
    @Json(name = "token_type") val tokenType: String?,
    @Json(name = "expires_in") val expiresIn: Int?,
    @Json(name = "refresh_token") val refreshToken: String?,
    @Json(name = "created_at") val createdAt: String?,
)
