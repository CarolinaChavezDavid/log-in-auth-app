package com.carolina.log_in_auth_app.auth.data.api

import com.carolina.log_in_auth_app.auth.data.datasource.AuthLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthTokenInterceptor@Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.header("Authorization", "Bearer ${authLocalDataSource.getAuthToken()}")

        return chain.proceed(builder.build())
    }
}
