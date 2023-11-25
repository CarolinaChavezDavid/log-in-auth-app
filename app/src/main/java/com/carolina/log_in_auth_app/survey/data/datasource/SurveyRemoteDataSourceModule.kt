package com.carolina.log_in_auth_app.survey.data.datasource

import com.carolina.log_in_auth_app.auth.data.api.AuthTokenInterceptor
import com.carolina.log_in_auth_app.survey.data.api.SurveyService
import com.squareup.moshi.Moshi
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
class SurveyRemoteDataSourceModule {

    @Provides
    @Singleton
    fun surveyProvideApi(
        accessTokenInterceptor: AuthTokenInterceptor,
        moshi: Moshi,
    ): SurveyService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://survey-api.nimblehq.co")
            .client(OkHttpClient.Builder().addInterceptor(accessTokenInterceptor).build())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()

        return retrofit.create(SurveyService::class.java)
    }
}
