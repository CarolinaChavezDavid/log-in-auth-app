package com.carolina.log_in_auth_app.ui.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AuthEntity(
    @PrimaryKey
    val fixedId: Int = 1,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "access_token") val accessToken: String,
    @ColumnInfo(name = "token_type") val tokenType: String,
    @ColumnInfo(name = "expires_in") val expiresIn: Int,
    @ColumnInfo(name = "refresh_token") val refreshToken: String,
    @ColumnInfo(name = "created_at") val createdAt: String,
)
