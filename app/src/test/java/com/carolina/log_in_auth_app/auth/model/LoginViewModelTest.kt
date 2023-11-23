package com.carolina.log_in_auth_app.auth.model

import androidx.lifecycle.Observer
import com.carolina.log_in_auth_app.auth.usecase.LoginUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class LoginViewModelTest {
    private lateinit var viewModel: LoginViewModel
    private val mockLoginUseCase: LoginUseCase = mock()
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        viewModel = LoginViewModel(mockLoginUseCase)
    }

    @Test
    fun `when updateEmail method is executed then email is updated`() {
        val testEmail = "test@example.com"
        viewModel.updateEmail(testEmail)
        assert(viewModel.email == testEmail)
    }

    @Test
    fun `when updatePassword method is executed then password is updated`() {
        val testPassword = "testPassword"
        viewModel.updatePassword(testPassword)
        assert(viewModel.password == testPassword)
    }

    @Test
    fun `when performLogin method is executed then loginUseCase is called`() =
        testDispatcher.runBlockingTest {
            val testEmail = "test@example.com"
            val testPassword = "testPassword"
            viewModel.updateEmail(testEmail)
            viewModel.updatePassword(testPassword)
            viewModel.performLogin()
            verify(mockLoginUseCase).execute(testEmail, testPassword)
        }

    @Test
    fun `when performLogin method is executed then loading state is set`() = testDispatcher.runBlockingTest {
        val observer: Observer<LoginState> = mock()
        viewModel.uiState.observeForever(observer)
        viewModel.performLogin()
        assert(viewModel.uiState.value is LoginState.Loading)
        verify(observer).onChanged(LoginState.Loading)
        viewModel.uiState.removeObserver(observer)
    }
}
