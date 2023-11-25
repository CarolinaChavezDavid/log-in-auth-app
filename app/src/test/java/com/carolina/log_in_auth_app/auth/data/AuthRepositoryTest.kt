package com.carolina.log_in_auth_app.auth.data

import com.carolina.log_in_auth_app.auth.data.datasource.AccessTokenRequest
import com.carolina.log_in_auth_app.auth.data.datasource.AuthLocalDataSource
import com.carolina.log_in_auth_app.auth.data.datasource.AuthRemoteDataSource
import com.carolina.log_in_auth_app.auth.data.mappers.toTokenEntity
import com.carolina.log_in_auth_app.auth.data.repository.AuthRepository
import com.carolina.log_in_auth_app.auth.data.response.AuthResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class AuthRepositoryTest {

    private lateinit var authRepository: AuthRepository
    private val mockAuthRemoteDataSource: AuthRemoteDataSource = mock()
    private val mockAuthLocalDataSource: AuthLocalDataSource = mock()

    @Before
    fun setup() {
        authRepository = AuthRepository(mockAuthRemoteDataSource, mockAuthLocalDataSource)
    }

    @Test
    fun `login() should call remote data source and insert token into local data source`() = runBlocking {
        val email = "test@example.com"
        val password = "testPassword"
        val accessTokenRequest = AccessTokenRequest(
            grantType = AuthRepository.GRANT_TYPE,
            email = email,
            password = password,
            clientId = AuthRepository.CLIENT_ID,
            clientSecret = AuthRepository.CLIENT_SECRET,
        )
        val mockTokenEntity: AuthResponse = mock()

        `when`(mockAuthRemoteDataSource.userLogIn(accessTokenRequest)).thenReturn(mockTokenEntity)

        authRepository.login(email, password)
        verify(mockAuthRemoteDataSource).userLogIn(accessTokenRequest)
        verify(mockAuthLocalDataSource).insertAuthToken(mockTokenEntity.toTokenEntity())
    }
}
