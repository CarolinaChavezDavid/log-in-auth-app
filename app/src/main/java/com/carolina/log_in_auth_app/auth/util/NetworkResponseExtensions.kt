package com.carolina.log_in_auth_app.auth.util

import retrofit2.Response

fun <T> Response<T>.parseResponse(): T {
    val body = this.body()
    if (this.isSuccessful && body != null) {
        return body
    } else {
        throw Exception(
            "Network error ${this.code()} body: ${this.errorBody()} ${this.message()}",
            Throwable(),
        )
    }
}
