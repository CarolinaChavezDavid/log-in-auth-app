package com.carolina.log_in_auth_app.survey.data.datasource

import com.squareup.moshi.Json

data class SurveyRequestDto(
    @Json(name = "size") val size: String,
    @Json(name = "number") val number: String,
)
