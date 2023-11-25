package com.carolina.log_in_auth_app.survey.data.api

import com.carolina.log_in_auth_app.survey.data.response.SurveyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SurveyService {
    @GET("api/v1/surveys")
    suspend fun getSurveyList(
        @Query("page[number]") pageNumber: String,
        @Query("page[size]") pageSize: String,
    ): Response<SurveyResponse>
}
