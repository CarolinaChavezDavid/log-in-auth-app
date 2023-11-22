package com.carolina.log_in_auth_app.ui.data

import com.carolina.log_in_auth_app.ui.data.datasource.AuthLocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(
    authLocalDataSource: AuthLocalDataSource,
) {

    private var _accessToken: String = ""
    val accessToken get() = _accessToken

    private var disposable: Disposable

    init {
        val userFlowable = authLocalDataSource
            .getAuthTokenFlowable()
        disposable = userFlowable
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _accessToken = it?.accessToken ?: ""
            }, {
                // Do nothing
            })
    }
}
