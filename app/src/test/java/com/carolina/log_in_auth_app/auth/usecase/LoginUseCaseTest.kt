package com.carolina.log_in_auth_app.auth.usecase

import com.carolina.log_in_auth_app.auth.data.AuthRepository
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

class LoginUseCaseTest {
    private val mockAuthRepository: AuthRepository = mock()
    private val loginUseCase = LoginUseCase(mockAuthRepository)

    @Test
    fun `when useCase is executed then repository is called with right arguments`() = runBlockingTest {
        val email = "test@example.com"
        val password = "password"

        loginUseCase.execute(email, password)
        verify(mockAuthRepository).login(email, password)
    }

    @Test
    fun `execute() switches to the IO dispatcher`() = runBlockingTest {
        val email = "test@example.com"
        val password = "password"

        loginUseCase.execute(email, password)
        verify(mockAuthRepository).login(email, password)
        verify(mockAuthRepository).login(any(), any())
    }
}
