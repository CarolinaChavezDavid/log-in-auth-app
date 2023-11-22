package com.carolina.log_in_auth_app.ui.data

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthTokenInterceptor@Inject constructor(
    private val authManager: AuthManager,
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (chain.request().headers[API_KEY].isNullOrEmpty()) {
            builder.header(API_KEY, "Bearer ${authManager.accessToken}")
        }

        return chain.proceed(builder.build())
    }

    companion object {
        const val API_KEY = "Authorization"
    }
}
