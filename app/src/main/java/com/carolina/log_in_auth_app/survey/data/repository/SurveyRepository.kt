package com.carolina.log_in_auth_app.survey.data.repository

import android.util.Log
import com.carolina.log_in_auth_app.survey.data.datasource.SurveyRemoteDataSource
import com.carolina.log_in_auth_app.survey.data.datasource.SurveyRequestDto
import com.carolina.log_in_auth_app.survey.data.mappers.toSurveyDataModel
import com.carolina.log_in_auth_app.survey.data.model.SurveyDataModel
import javax.inject.Inject

class SurveyRepository @Inject constructor(
    private val surveyRemoteDataSource: SurveyRemoteDataSource,
) {

    suspend fun getSurveyList(): List<SurveyDataModel> {
        val surveyRequest = SurveyRequestDto(
            size = "3",
            number = "1",
        )
        val survey = surveyRemoteDataSource.getSurveyList(surveyRequest).toSurveyDataModel().surveys

        Log.d("Survey get", survey.toString())
        return survey
    }
}
