package com.example.sahabatmakara.domain.usecase

import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.repository.FacultyRepository
import kotlinx.coroutines.flow.Flow

class FacultyInteractor(
    private val facultyRepository: FacultyRepository
): FacultyUseCase {
    override fun getFmipaMajor(): Flow<List<FmipaMajor>> = facultyRepository.getFmipaMajor()
}