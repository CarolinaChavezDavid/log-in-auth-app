package com.carolina.log_in_auth_app.survey.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolina.log_in_auth_app.survey.data.repository.SurveyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class SurveyListViewModel @Inject constructor(
    private val repository: SurveyRepository,
) : ViewModel() {

    private var _uiState: MutableLiveData<SurveyState> = MutableLiveData<SurveyState>()
    var uiState: LiveData<SurveyState> = _uiState

    fun fetchSurveyList() {
        _uiState.value = SurveyState.Loading
        viewModelScope.launch {
            try {
                _uiState.value = SurveyState.Success(repository.getSurveyList())
            } catch (e: Throwable) {
                _uiState.value = SurveyState.Error("Network Request failed")
            }
        }
    }
}
