package com.example.sahabatmakara.domain.usecase

import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.interfaces.FacultyRepository
import kotlinx.coroutines.flow.Flow

class FacultyInteractor(
    private val facultyRepository: FacultyRepository
): FacultyUseCase {
    override fun getFmipaMajor(): Flow<List<FmipaMajor>> = facultyRepository.getFmipaMajor()
    override fun getDetailFmipaMajor(major: String): Flow<FmipaMajor> = facultyRepository.getDetailFmipaMajor(major)

}