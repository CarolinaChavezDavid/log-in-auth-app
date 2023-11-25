package com.carolina.log_in_auth_app.survey.data.mappers

import com.carolina.log_in_auth_app.survey.data.model.MetaDataModel
import com.carolina.log_in_auth_app.survey.data.model.SurveyAttributesModel
import com.carolina.log_in_auth_app.survey.data.model.SurveyDataModel
import com.carolina.log_in_auth_app.survey.data.model.SurveyDataModelResponse
import com.carolina.log_in_auth_app.survey.data.response.MetaResponseData
import com.carolina.log_in_auth_app.survey.data.response.SurveyAttributesResponseData
import com.carolina.log_in_auth_app.survey.data.response.SurveyResponse
import com.carolina.log_in_auth_app.survey.data.response.SurveyResponseData

fun SurveyResponse.toSurveyDataModel(): SurveyDataModelResponse = SurveyDataModelResponse(
    surveys = this.surveys!!.map { it.toSurveyDataModel() },
    metadata = this.metadata!!.toMetaDataModel(),

)

fun MetaResponseData.toMetaDataModel(): MetaDataModel = MetaDataModel(
    page = this.page ?: 0,
    pages = this.pages ?: 0,
    pageSize = this.pages ?: 0,
    records = this.pages ?: 0,
)

fun SurveyResponseData.toSurveyDataModel() = SurveyDataModel(
    id = this.id ?: "",
    type = this.type ?: "",
    attributes = this.attributes!!.toSurveyAttributesModel(),
)

fun SurveyAttributesResponseData.toSurveyAttributesModel() = SurveyAttributesModel(
    title = this.title ?: "",
    description = this.description ?: "",
    thankEmailAboveThreshold = this.thankEmailAboveThreshold ?: "",
    thankEmailBelowThreshold = this.thankEmailBelowThreshold ?: "",
    isActive = this.isActive ?: false,
    coverImageUrl = this.coverImageUrl ?: "",
    createdAt = this.createdAt ?: "",
    activeAt = this.activeAt ?: "",
    inactiveAt = this.inactiveAt ?: "",
    surveyType = this.surveyType ?: "",

)
