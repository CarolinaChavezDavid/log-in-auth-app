package com.carolina.log_in_auth_app.survey.model

import com.carolina.log_in_auth_app.survey.data.model.SurveyDataModel

sealed interface SurveyState {
    object Loading : SurveyState
    data class Success(val surveys: List<SurveyDataModel>) : SurveyState
    data class Error(val message: String) : SurveyState
}
