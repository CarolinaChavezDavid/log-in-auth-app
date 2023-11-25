package com.carolina.log_in_auth_app.survey.data.datasource

import com.carolina.log_in_auth_app.auth.util.parseResponse
import com.carolina.log_in_auth_app.survey.data.api.SurveyService
import com.carolina.log_in_auth_app.survey.data.response.SurveyResponse
import javax.inject.Inject

class SurveyRemoteDataSource @Inject constructor(
    private val surveyService: SurveyService,
) {

    suspend fun getSurveyList(surveyDto: SurveyRequestDto): SurveyResponse {
        return surveyService.getSurveyList(
            surveyDto.number,
            surveyDto.size,
        ).parseResponse()
    }
}
