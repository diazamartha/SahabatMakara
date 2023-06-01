package com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.usecase.FacultyUseCase
import com.example.sahabatmakara.presentation.common.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FmipaViewModel(
    private val facultyUseCase: FacultyUseCase
): ViewModel() {

    private val _fmipaMajor = MutableStateFlow<Result<List<FmipaMajor>>>(Result.Loading)
    val fmipaMajor = _fmipaMajor.asStateFlow()

    private val _fmipaMajorDetail = MutableStateFlow<Result<FmipaMajor>>(Result.Loading)
    val fmipaMajorDetail = _fmipaMajorDetail.asStateFlow()

    var isDialogShown by mutableStateOf(false)
        private set

    private var selectedFmipaMajor: String = ""

    fun onItemClick(major: String) {
        selectedFmipaMajor = major
        getDetailFmipaMajor(major)
        isDialogShown = true
    }

    fun getSelectedEmployeeUuid(): String {
        return selectedFmipaMajor
    }

    fun onDismissDialog() {
        isDialogShown = false
        selectedFmipaMajor = ""
    }

    fun getFmipaMajor() {
        viewModelScope.launch {
            facultyUseCase.getFmipaMajor()
                .catch {
                    _fmipaMajor.value = Result.Error(it.message.toString())
                }
                .collect { fmipaMajors ->
                    _fmipaMajor.value = Result.Success(fmipaMajors)
                }
        }
    }

    fun getDetailFmipaMajor(major: String) {
        viewModelScope.launch {
            facultyUseCase.getDetailFmipaMajor(major)
                .catch { error ->
                    _fmipaMajorDetail.value = Result.Error(error.message.toString())
                }
                .collect { detail ->
                    _fmipaMajorDetail.value = Result.Success(detail)
                }
        }
    }
}