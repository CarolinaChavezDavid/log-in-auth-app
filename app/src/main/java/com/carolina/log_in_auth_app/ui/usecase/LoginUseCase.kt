package com.carolina.log_in_auth_app.ui.usecase

import com.carolina.log_in_auth_app.ui.data.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend fun execute(email: String, password: String) {
        withContext(dispatcher) {
            authRepository.login(email, password)
        }
    }
}
