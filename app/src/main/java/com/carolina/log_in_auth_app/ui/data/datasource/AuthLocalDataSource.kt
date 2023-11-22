package com.carolina.log_in_auth_app.ui.data.datasource

import com.carolina.log_in_auth_app.ui.data.database.AppDatabase
import com.carolina.log_in_auth_app.ui.data.database.entities.AuthEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(appDatabase: AppDatabase) {
    private val authTokenEntityDao = appDatabase.authTokenDao()

    suspend fun getAuthToken(): AuthEntity? {
        return authTokenEntityDao.getAuthToken()
    }

    fun getAuthTokenFlow(): Flow<AuthEntity?> {
        return authTokenEntityDao.getAuthTokenFlow()
    }

    suspend fun insertAuthToken(authTokenEntity: AuthEntity) {
        authTokenEntityDao.insertAuthToken(authTokenEntity)
    }
}
