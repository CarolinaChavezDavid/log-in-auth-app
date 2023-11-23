package com.carolina.log_in_auth_app.auth.data

import com.squareup.moshi.Json

data class AccessTokenRequest(
    @Json(name = "grant_type") val grantType: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String,
    @Json(name = "client_id") val clientId: String,
    @Json(name = "client_secret") val clientSecret: String,
)
