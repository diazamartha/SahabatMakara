package com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.usecase.FacultyUseCase
import com.example.sahabatmakara.presentation.common.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FmipaViewModel(
    private val facultyUseCase: FacultyUseCase
): ViewModel() {

    private val _fmipaMajor = MutableStateFlow<Result<List<FmipaMajor>>>(Result.Loading)
    val fmipaMajor = _fmipaMajor.asStateFlow()

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
}