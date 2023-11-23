package com.carolina.log_in_auth_app.auth.data.mappers

import com.carolina.log_in_auth_app.auth.data.database.entities.AuthEntity
import com.carolina.log_in_auth_app.auth.data.response.AuthResponse

fun AuthResponse.toTokenEntity(): AuthEntity = AuthEntity(
    fixedId = 1,
    id = this.data?.id ?: "",
    type = this.data?.type ?: "",
    accessToken = this.data?.attributes?.accessToken ?: "",
    tokenType = this.data?.attributes?.tokenType ?: "",
    expiresIn = this.data?.attributes?.expiresIn ?: 0,
    refreshToken = this.data?.attributes?.refreshToken ?: "",
    createdAt = this.data?.attributes?.createdAt ?: "0",
)
