package com.carolina.log_in_auth_app.ui.data.datasource

import com.carolina.log_in_auth_app.ui.data.AuthService
import com.carolina.log_in_auth_app.ui.data.AuthTokenInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthDataSourceModule {

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        accessTokenInterceptor: AuthTokenInterceptor,
    ): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(accessTokenInterceptor)
        return okHttpClientBuilder
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideApi(
        okHttpClientBuilder: OkHttpClient.Builder,
        moshi: Moshi,
    ): AuthService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://survey-api.nimblehq.co")
            .client(okHttpClientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()

        return retrofit.create(AuthService::class.java)
    }
}