package com.carolina.log_in_auth_app.ui.util

import retrofit2.Response

fun <T> Response<T>.parseResponse(): T {
    val body = this.body()
    if (this.isSuccessful && body != null) {
        return body
    } else {
        throw Exception(
            "$this.code() $this.message()",
            Throwable(),
        )
    }
}
