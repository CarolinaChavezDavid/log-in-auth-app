package com.carolina.log_in_auth_app.survey.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyResponse(
    @Json(name = "data") val surveys: List<SurveyResponseData>?,
    @Json(name = "meta") val metadata: MetaResponseData?,
)

@JsonClass(generateAdapter = true)
data class SurveyResponseData(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "attributes") val attributes: SurveyAttributesResponseData?,
)

@JsonClass(generateAdapter = true)
data class SurveyAttributesResponseData(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "thank_email_above_threshold") val thankEmailAboveThreshold: String?,
    @Json(name = "thank_email_below_threshold") val thankEmailBelowThreshold: String?,
    @Json(name = "is_active") val isActive: Boolean?,
    @Json(name = "cover_image_url") val coverImageUrl: String?,
    @Json(name = "created_at") val createdAt: String?,
    @Json(name = "active_at") val activeAt: String?,
    @Json(name = "inactive_at") val inactiveAt: String?,
    @Json(name = "survey_type") val surveyType: String?,
)
@JsonClass(generateAdapter = true)
data class MetaResponseData(
    @Json(name = "page") val page: Int?,
    @Json(name = "pages") val pages: Int?,
    @Json(name = "page_size") val pageSize: Int?,
    @Json(name = "records") val records: Int?,
)
