package com.carolina.log_in_auth_app.survey.data.model

data class SurveyDataModelResponse(
    val surveys: List<SurveyDataModel>,
    val metadata: MetaDataModel,
)

data class SurveyDataModel(
    val id: String,
    val type: String,
    val attributes: SurveyAttributesModel,
)

data class SurveyAttributesModel(
    val title: String = "",
    val description: String = "",
    val thankEmailAboveThreshold: String = "",
    val thankEmailBelowThreshold: String = "",
    val isActive: Boolean = false,
    val coverImageUrl: String = "",
    val createdAt: String = "",
    val activeAt: String = "",
    val inactiveAt: String = "",
    val surveyType: String = "",
)

data class MetaDataModel(
    val page: Int,
    val pages: Int,
    val pageSize: Int,
    val records: Int,
)
